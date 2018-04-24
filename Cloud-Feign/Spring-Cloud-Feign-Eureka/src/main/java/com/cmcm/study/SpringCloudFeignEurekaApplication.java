package com.cmcm.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudFeignEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignEurekaApplication.class, args);
	}
}
