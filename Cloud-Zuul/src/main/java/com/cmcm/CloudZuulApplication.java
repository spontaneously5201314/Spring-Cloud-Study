package com.cmcm;

import com.cmcm.filter.MyZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class CloudZuulApplication {

    @Bean
    public MyZuulFilter myZuulFilter(){
        return new MyZuulFilter();
    }

	public static void main(String[] args) {
		SpringApplication.run(CloudZuulApplication.class, args);
	}
}
