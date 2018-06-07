package com.cmcm.study.controller;

import com.alibaba.fastjson.JSON;
import com.cmcm.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hongfei
 * @create 2018-05-16 下午7:04
 */
@RestController
public class ConsumerUserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User find(@PathVariable Long id){
        return this.restTemplate.getForObject("http://cloud-feign-provider/" + id, User.class);
    }

    @GetMapping("/testLoadChoose")
    @ResponseBody
    public String testLoadChoose(){
        ServiceInstance instance = loadBalancerClient.choose("cloud-feign-provider");
        return JSON.toJSONString(instance);
    }

}
