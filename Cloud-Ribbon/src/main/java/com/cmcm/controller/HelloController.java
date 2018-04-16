package com.cmcm.controller;

import com.cmcm.ribbon.MyRibbonConfiguration;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongfei
 * @create 2018-03-19 下午8:37
 */
@RestController
@RibbonClient(name = "hello-controller", configuration = MyRibbonConfiguration.class)
public class HelloController {

    @LoadBalanced
    @GetMapping("/index")
    public String say(){
        Config config = ConfigService.getConfig("application");
        String key = "test2";
        String defaultValue = "hongfei";
        return config.getProperty(key, defaultValue);
    }
}
