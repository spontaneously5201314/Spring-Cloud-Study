package com.cmcm.study;

import com.cmcm.study.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //实例化SpringApplication的两种方法，第一种
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        //实例化SpringApplication的两种方法，第二种
//		SpringApplication application = new SpringApplication();
//		Set<Object> resources = new HashSet<>();
//		resources.add(Application.class);
//		application.setSources(resources);
//		application.run(args);

        //获取配置，第一种
        System.out.println(context.getEnvironment().getProperty("spring.profiles.active"));
        //获取配置，第二种
        context.getBean(MyConfig.class).show();
        //获取配置，第三种使用@Value注解

    }
}
