package com.cmcm.controller;

import com.cmcm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongfei
 * @create 2018-03-20 下午8:13
 */
@RestController
public class HystrixController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.call();
    }
}
