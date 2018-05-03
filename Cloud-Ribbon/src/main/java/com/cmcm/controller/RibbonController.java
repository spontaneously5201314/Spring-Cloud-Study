package com.cmcm.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hongfei
 * @create 2018-05-02 下午8:37
 */
@RestController
public class RibbonController {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public String getInfo(){
        return restTemplate().getForEntity("http://www.baidu.com", String.class).getBody();
    }

}
