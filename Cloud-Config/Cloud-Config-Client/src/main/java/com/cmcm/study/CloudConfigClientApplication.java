package com.cmcm.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@RefreshScope
@EnableEurekaClient
@SpringBootApplication
public class CloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigClientApplication.class, args);
	}
}
