package com.cmcm.study;

import cmcm.chapter.domain.Person;
import com.cmcm.study.importer.registry.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableContentService
//@EnableAsync
//@Import(MyImportSelector.class)
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
//        System.out.println(context.getEnvironment().getProperty("spring.profiles.active"));
        //获取配置，第二种
//        context.getBean(MyConfig.class).show();
        //获取配置，第三种使用@Value注解


        //Condition
//        Object restTemplate = context.getBean("restTemplate");
//        System.out.println(restTemplate);


        //测试@Import注解
//        System.out.println(context.getBean(EnableContentService.SimpleContentService.class));


        //异步调用
//        context.getBean(Runnable.class).run();
//        System.out.println("异步调用完毕");

        //看看自己注册使用的registry能不能使用
//        System.out.println(context.getBean(Person.class));
//        System.out.println(context.getBean("spontaneously"));
//        context.close();
    }
}
