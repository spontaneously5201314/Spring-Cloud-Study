package com.cmcm.study.controller;

import com.alibaba.fastjson.JSON;
import com.cmcm.study.entity.User;
import com.cmcm.study.entity.UserDemo;
import com.cmcm.study.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hongfei
 * @create 2018-04-20 下午5:50
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String demoServiceTest() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.helloService("yuanyuan"));
        sb.append("\n");
        sb.append(helloService.helloService("yjt", "xixihaha"));
        sb.append("\n");
        sb.append(helloService.helloService(new UserDemo(1, "yejingtao", 26)));
        return sb.toString();

    }


    @GetMapping(value = "/getName/{id}")
    public String getNameById(@PathVariable("id") Long id){
        return helloService.getNameById(id);
    }

    @PostMapping(value = "/saveUser")
    @ResponseBody
    public User saveUser(/*@RequestBody*/ User user){
        System.out.println("User:" + JSON.toJSONString(user));
        return helloService.saveUser(user);
    }
}
