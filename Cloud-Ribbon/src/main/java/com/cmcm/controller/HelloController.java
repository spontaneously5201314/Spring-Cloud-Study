package com.cmcm.controller;

import com.cmcm.config.PropertyConfigurer;
import com.cmcm.ribbon.MyRibbonConfiguration;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${name}")
    private String name;

    @LoadBalanced
    @GetMapping("/index")
    public String say(String nameSpace, String key) {
        Config config = ConfigService.getConfig(nameSpace);
        ConfigService.getAppConfig();
        String defaultValue = "default";
        String property = config.getProperty(key, defaultValue);
        if (defaultValue.equals(property)) {
            property = ConfigService.getAppConfig().getProperty(key, defaultValue);
        }
        return property;
    }

    @LoadBalanced
    @GetMapping("/say")
    public String hello(String key){
        String result = PropertyConfigurer.getString(key);
        if ("name".equals(key)){
            return name;
        }
        return result;
    }
}
