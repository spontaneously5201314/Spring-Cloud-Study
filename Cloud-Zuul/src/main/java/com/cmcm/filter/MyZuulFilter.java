package com.cmcm.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hongfei
 * @create 2018-04-24 下午3:50
 */
public class MyZuulFilter extends ZuulFilter{

    private static final Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token) || StringUtils.isBlank(token)){
            try {
                doSomething();
            } catch (Exception e) {
                currentContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                currentContext.set("error.exception", "这里发生了错误");
            }
        }
        return null;
    }

    private void doSomething(){
        throw new RuntimeException("没有收到token");
    }
}
