package com.cmcm.controller;

import com.cmcm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hongfei
 * @create 2018-03-20 下午8:13
 */
@RestController
public class HystrixController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public String getInfo(){
        return restTemplate.getForEntity("http://ribbon/getInfo", String.class).getBody();
    }

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.call();
    }
}
