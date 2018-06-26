package com.cmcm.study;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringBootAdminServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAdminServerDemoApplication.class, args);
	}
}
