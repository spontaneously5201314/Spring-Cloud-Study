package com.cmcm.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudFeignCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignCommonApplication.class, args);
	}
}
