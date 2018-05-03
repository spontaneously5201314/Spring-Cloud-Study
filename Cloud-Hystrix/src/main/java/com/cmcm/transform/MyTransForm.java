package com.cmcm.transform;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestTransformer;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

/**
 * @author hongfei
 * @create 2018-05-03 上午11:15
 */
//@Component
public class MyTransForm implements LoadBalancerRequestTransformer{
    @Override
    public HttpRequest transformRequest(HttpRequest request, ServiceInstance instance) {
        System.out.println("调用了自己实现的LoadBalancerRequestTransformer");
        return null;
    }
}
