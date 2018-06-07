#!/usr/bin/env bash
iplist=("10.46.100.35 10.46.100.146" "10.46.100.141 10.46.100.221" "10.46.100.153 10.46.100.203" "10.46.100.194 10.46.100.152" "10.46.100.23 10.46.100.216"\
 "10.46.100.191 10.46.100.97" "10.46.100.222 10.46.100.144" "10.46.100.9 10.46.100.71" "10.46.100.215 10.46.100.214" "10.46.100.181 10.46.100.237")


while [ true ]; do
datename=$(date +%Y%m%d-%H);
datedir=$(date +%Y%m%d);


n_ips=${#iplist[*]}     #获取一维iplist的数组长度

for ((i=0;i<$n_ips;i++));
do
        result=""
        inner_ips=(${iplist[$i]}) #将一维iplist字符串赋值到数组
        n_inner_ips=${#inner_ips[*]} #获取二维iplist的数组长度
        j=`expr $i + 1`
        #echo ${inner_ips[0]}  ${inner_ips[1]}  #回显ip  #回显ip
        #netty组
        mkdir -p /data/logs/time_out_check_netty${j}/$datedir
        #此处访问的是netty->tomcat的nginx
        result=$(curl -s "http://${inner_ips[1]}:9007/arrow/timeOutCheck?key=GQVNC-24YPY-KHJB4&nettyId=${inner_ips[1]}:9007")
        echo "http://${inner_ips[1]}:9007/arrow/timeOutCheck?key=GQVNC-24YPY-KHJB4&nettyId=${inner_ips[1]}:9007" >> /data/logs/time_out_check_netty${j}/$datedir/$datename.log
        echo $result >> /data/logs/time_out_check_netty${j}/$datedir/$datename.log
        #echo $result
        echo  >> /data/logs/time_out_check_netty${j}/$datedir/$datename.log

        sleep 3

done

sleep 60
done