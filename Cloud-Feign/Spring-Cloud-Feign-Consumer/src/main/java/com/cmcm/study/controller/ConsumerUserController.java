package com.cmcm.study.controller;

import com.cmcm.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/user/{id}")
    public User find(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
    }

}
