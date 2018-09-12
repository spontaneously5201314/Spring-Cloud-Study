package com.cmcm.study.controller;

import com.cmcm.study.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spontaneously
 * @time 2018-09-07 下午2:28
 */
@RestController
@RequestMapping(value = "/order")
public class TestController {

    @Autowired
    private DemoService demoService;

    @PostMapping
    public String insertOrder(Integer userId) {
        return demoService.insert(userId);
    }
}
