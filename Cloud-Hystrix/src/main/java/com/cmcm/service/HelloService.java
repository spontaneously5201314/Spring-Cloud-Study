package com.cmcm.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hongfei
 * @create 2018-03-20 下午8:18
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "failBack")
    public String call() {
        return restTemplate.getForEntity("http://ribbon/index", String.class).getBody();
    }

    private String failBack() {
        return "fuck";
    }
}
