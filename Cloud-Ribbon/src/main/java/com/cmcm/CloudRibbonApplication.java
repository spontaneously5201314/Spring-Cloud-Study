package com.cmcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author hongfei
 * @create 2018-03-19 下午8:34
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudRibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate template(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudRibbonApplication.class, args);
    }
}
