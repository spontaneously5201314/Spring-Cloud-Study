//package com.cmcm.controller;
//
//importannotation com.cmcm.config.PropertyConfigurer;
//importannotation com.cmcm.ribbon.MyRibbonConfiguration;
//importannotation com.ctrip.framework.apollo.Config;
//importannotation com.ctrip.framework.apollo.ConfigService;
//importannotation org.springframework.beans.factory.annotation.Value;
//importannotation org.springframework.cloud.client.loadbalancer.LoadBalanced;
//importannotation org.springframework.cloud.netflix.ribbon.RibbonClient;
//importannotation org.springframework.web.bind.annotation.GetMapping;
//importannotation org.springframework.web.bind.annotation.RestController;
//
///**
// * @author hongfei
// * @create 2018-03-19 下午8:37
// */
//@RestController
//@RibbonClient(name = "hello-controller", configuration = MyRibbonConfiguration.class)
//public class HelloController {
//
//    @Value("${name}")
//    private String name;
//
//    @LoadBalanced
//    @GetMapping("/index")
//    public String say(String nameSpace, String key) {
//        Config config = ConfigService.getConfig(nameSpace);
//        ConfigService.getAppConfig();
//        String defaultValue = "default";
//        String property = config.getProperty(key, defaultValue);
//        if (defaultValue.equals(property)) {
//            property = ConfigService.getAppConfig().getProperty(key, defaultValue);
//        }
//        return property;
//    }
//
//    @LoadBalanced
//    @GetMapping("/say")
//    public String hello(String key){
//        String result = PropertyConfigurer.getString(key);
//        if ("name".equals(key)){
//            return name;
//        }
//        return result;
//    }
//}
