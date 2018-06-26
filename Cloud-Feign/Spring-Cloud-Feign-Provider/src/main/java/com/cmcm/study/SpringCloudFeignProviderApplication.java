package com.cmcm.study;

//import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * EnableEurekaClient和EnableDiscoveryClient的区别:
 * EnableDiscoveryClient表示不一定是使用eureka作为注册中心,而EnableEurekaClient表示一定是使用eureka作为注册中心的时候
 * EnableDiscoveryClient在任何时候都可以使用
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
//@EnableAdminServer
public class SpringCloudFeignProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignProviderApplication.class, args);
	}
}
