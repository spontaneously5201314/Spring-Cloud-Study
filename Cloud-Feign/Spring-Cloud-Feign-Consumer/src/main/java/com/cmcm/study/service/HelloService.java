package com.cmcm.study.service;

import com.cmcm.study.entity.User;
import com.cmcm.study.entity.UserDemo;
import com.cmcm.study.service.impl.DefaultFallbackHelloService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author hongfei
 * @create 2018-04-20 下午5:34
 */
@Qualifier(value = "helloService")
@FeignClient(name = "cloud-feign-provider", fallback = DefaultFallbackHelloService.class)
public interface HelloService {

    //第一个坑,@GetMapping注解不支持
    @RequestMapping(value = "/feign-service/serviceGet", method = RequestMethod.GET)
    String helloService(@RequestParam("name") String name);

    //第二个坑,@PathVariable("id")该注解中必须设置value,不能写成@PathVariable
    @RequestMapping(value = "/getNameById/{id}", method = RequestMethod.GET)
    String getNameById(@PathVariable("id") Long id);

    @RequestMapping(value = "/feign-service/serviceHead", method = RequestMethod.HEAD)
    String helloService(@RequestHeader("name") String name, @RequestHeader("password") String password);

    @RequestMapping(value = "/feign-service/servicePost", method = RequestMethod.POST)
    String helloService(@RequestBody UserDemo userDemo);

    //这里有一个坑,就是如果接收的对象是复杂的对象,即使设置了是GET方法,也会被feign设置为post方法
    //如果一定要多个参数传递,只能把每个参数都写在参数列表中,像@PathVariable("id") Long id这样
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    User saveUser(/*@RequestBody*/ User user);
}
