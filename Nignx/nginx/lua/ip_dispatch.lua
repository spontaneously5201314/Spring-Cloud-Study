dofile("/usr/local/nginx_lua/conf/ip_dispatch_conf.lua")

--init a redis
local redis = require "redis"

ngx.log(ngx.ERR, "get config  " .. redis_host_ip .. "  " .. redis_host_port)
ngx.log(ngx.ERR, "ngx.var.remote_addr ", ngx.var.remote_addr)

function get_client_ip()
    local headers = ngx.req.get_headers()
    ngx.log(ngx.ERR, "X-REAL-IP ", headers["X-REAL-IP"])
    ngx.log(ngx.ERR, "X_FORWARDED_FOR ", headers["X_FORWARDED_FOR"])
    ngx.log(ngx.ERR, "ngx.var.remote_addr ", ngx.var.remote_addr)
    local ip = headers["X-REAL-IP"] or headers["X_FORWARDED_FOR"] or ngx.var.remote_addr or "0.0.0.0"
    return ip
end

function isnull(obj)
    if obj == ngx.null or obj == nil then
        return 1;
    end

    if type(obj) == "table" then
        if _G.next(obj) == nil then
            return 1
        end
    end
end

local function get_ip_number(ip)
    local o1, o2, o3, o4 = ip:match("(%d%d?%d?)%.(%d%d?%d?)%.(%d%d?%d?)%.(%d%d?%d?)")
    local num = 2 ^ 24 * o1 + 2 ^ 16 * o2 + 2 ^ 8 * o3 + o4
    return num
end

local function close_redis(red)
    if not red then
        return
    end

    local pool_max_idle_time = 20000
    local pool_size = 1000
    local ok, err = red:set_keepalive(pool_max_idle_time, pool_size)

    if not ok then
        ngx.log(ngx_ERR, "set redis keepalive error : ", err)
    end
end

function lua_string_split(str, split_char)
    local sub_str_tab = {}

    while (true) do
        local pos = string.find(str, split_char)
        if (not pos) then
            local size_t = table.getn(sub_str_tab)
            table.insert(sub_str_tab, size_t + 1, str)
            break
        end

        local sub_str = string.sub(str, 1, pos - 1)
        local size_t = table.getn(sub_str_tab)
        table.insert(sub_str_tab, size_t + 1, sub_str)
        local t = string.len(str)
        str = string.sub(str, pos + 1, t)
    end

    return sub_str_tab
end

local seg_sp = 256
local work_type = 1
--	local ipnumber = get_ip_number("220.181.42.237")
--	local ipnumber = get_ip_number("1.0.2.127")

local ipnumber = 99999999

local uri_args = ngx.req.get_uri_args()
if isnull(uri_args) ~= 1 then
    for k, v in pairs(uri_args) do
        if type(v) ~= "table" then
            if k == "ipnumber" then
                ipnumber = v
            end
            if k == "ip" then
                ipnumber = get_ip_number(v)
            end
            if k == "key" then
                if v == "63" or v == "64" or v == "70" or v == "82" then
                    ngx.log(ngx.ERR, "key 63 found !")
                    ngx.redirect("http://" .. config_local .. ngx.var.request_uri, 302)
                end
            end
        end
    end
end

local uri = ngx.var.request_uri

if (ipnumber == 99999999) then
    local ip = get_client_ip()
    if ip == "0.0.0.0" then
        ngx.log(ngx.ERR, "get remote ip error ")
        ngx.redirect("http://" .. default_local .. uri, 302)
        return
    end
    ngx.log(ngx.ERR, "get remote ip ok " .. ip)
    ipnumber = get_ip_number(ip)
    --		ipnumber = get_ip_number("209.170.125.208")
    work_type = 1
else
    work_type = 2
end
ngx.log(ngx.ERR, "get ip address type is ", ipnumber .. " work_type " .. work_type)
local seg_int, seg_remain = math.modf(ipnumber / seg_sp);

seg_remain = ipnumber - seg_int * seg_sp;

ngx.log(ngx.ERR, "get ip address ", ipnumber .. " int " .. seg_int .. " remain " .. seg_remain)

local red_global = redis.new()
local ok, err = red_global.connect(red_global, redis_host_ip, redis_host_port)
red_global:set_timeout(20000)

if not ok then
    ngx.log(ngx.ERR, "connect local redis error : ", redis_host_ip .. " " .. redis_host_port)
    ngx.redirect("http://" .. default_local .. uri, 302)
    return
end

if redis_host_pw ~= '' then
    local res, err = red_global:auth(redis_host_pw)
    if not res then
        close_redis(red_global)
        ngx.log(ngx.ERR, "connect local redis auth error : ", redis_host_ip .. " " .. redis_host_port .. " " .. redis_host_pw)
        ngx.redirect("http://" .. default_local .. uri, 302)
        return
    end
end

local bf = 0
local c_from = nil
local c_key = nil
local area_list, err = red_global:zrangebyscore(seg_int, -1, seg_remain, "withscores")
ngx.log(ngx.ERR, "check area list size ", table.getn(area_list))
local nlen = table.getn(area_list)

if nlen > 1 then
    bf = 1
    ngx.log(ngx.ERR, "check area list k ", area_list[nlen - 1] .. " v " .. area_list[nlen])
    c_from = area_list[nlen]
    c_key = area_list[nlen - 1]
end

if (c_from == nil) or (c_key == nil) then
    close_redis(red_global)
    ngx.log(ngx.ERR, "error in check area list, ipaddress ", ipnumber)
    ngx.redirect("http://" .. default_local .. uri, 302)
end

local tcompvalue = lua_string_split(c_key, '\'')

if table.getn(tcompvalue) ~= 4 then
    close_redis(red_global)
    ngx.log(ngx.ERR, "error in check area list arg error ", ipnumber)
    ngx.redirect("http://" .. default_local .. uri, 302)
end

if (seg_remain >= tonumber(c_from)) and (seg_remain <= tonumber(tcompvalue[2])) then
    bf = 1
else
    close_redis(red_global)
    ngx.log(ngx.ERR, "error in check area list arg comp ", ipnumber)
    ngx.redirect("http://" .. default_local .. uri, 302)
    return
end

local tfoundkey = tcompvalue[3]
ngx.log(ngx.ERR, "found in check area list ", tfoundkey)

if (work_type == 2) then
    tfoundkey = string.gsub(tfoundkey, "~", " ")
    local greatearray = lua_string_split(tfoundkey, '#')
    ngx.say("{\"country\":\"" .. greatearray[1] .. "\",\"province\":\"" .. greatearray[2] .. "\",\"city\":\"" .. greatearray[3] .. "\"}")
    close_redis(red_global)
    return;
end

local found = 0
local greatearray = lua_string_split(tfoundkey, '#')
if table.getn(greatearray) < 3 then
    close_redis(red_global)
    ngx.log(ngx.ERR, "error in check area list arg number ", ipnumber)
    ngx.redirect("http://" .. default_local .. uri, 302)
    return
end

found = 1
local country = greatearray[1]
local regiom = greatearray[2]
local city = greatearray[3]

ngx.log(ngx.ERR, "found result : ", found)

if (found == 1) then
    local key_country = country
    local key_country_regiom = country .. "_" .. regiom
    ngx.log(ngx.ERR, "found result : ", key_country .. " " .. key_country_regiom)
    if (key_country == "China") then
        ngx.log(ngx.ERR, "found result country is china: ")
        local area_key_regiom, err = red_global:get(key_country_regiom)
        if isnull(area_key_regiom) ~= 1 then
            ngx.log(ngx.ERR, "found country success : " .. area_key_regiom)
            local area_key, err = red_global:get(area_key_regiom)
            if isnull(area_key) ~= 1 then
                ngx.log(ngx.ERR, "found areakey success : " .. area_key)
                close_redis(red_global)
                ngx.redirect("http://" .. area_key .. uri, 302)
                return
            end
        end
    end

    local area_county_key = red_global:get(key_country)
    if isnull(area_county_key) ~= 1 then
        ngx.log(ngx.ERR, "found area_county_key : " .. area_county_key)
        local area_key, err = red_global:get(area_county_key)
        if isnull(area_key) ~= 1 then
            ngx.log(ngx.ERR, "found areakey success : " .. area_key)
            close_redis(red_global)
            ngx.redirect("http://" .. area_key .. uri, 302)
            return
        end
    end
else
    ngx.log(ngx.ERR, "error in found location : ", ipnumber)
end

close_redis(red_global)

ngx.log(ngx.ERR, "error in found location : ", ipnumber)

ngx.redirect("http://" .. default_local .. uri, 302)
