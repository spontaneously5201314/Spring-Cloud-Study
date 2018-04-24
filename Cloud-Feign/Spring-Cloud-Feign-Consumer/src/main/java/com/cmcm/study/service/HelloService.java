package com.cmcm.study.service;

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

    @RequestMapping(value = "/feign-service/serviceGet", method = RequestMethod.GET)
    String helloService(@RequestParam("name") String name);

    @RequestMapping(value = "/feign-service/serviceHead", method = RequestMethod.HEAD)
    String helloService(@RequestHeader("name") String name, @RequestHeader("password") String password);

    @RequestMapping(value = "/feign-service/servicePost", method = RequestMethod.POST)
    String helloService(@RequestBody UserDemo userDemo);
}
