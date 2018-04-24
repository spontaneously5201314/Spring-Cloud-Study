package com.cmcm.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongfei
 * @create 2018-04-24 下午3:30
 */
@RestController
@RequestMapping(value = "/common")
public class HelloController {

    @GetMapping("/get")
    public String get(){
        return "success";
    }
}
