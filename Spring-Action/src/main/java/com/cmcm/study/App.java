package com.cmcm.study;

import com.cmcm.study.bean.*;
import com.cmcm.study.config.MyBeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 * @autor spontaneously
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
//        System.out.println(context.getBean("&createRunnableFactoryBean"));
//        System.out.println(context.getBean(RunnableFactoryBean.class));
//        System.out.println(context.getBean("myBean"));
//        System.out.println(context.getBean(MyBean.class));
//        System.out.println(context.getBean(Car.class));
//        System.out.println(context.getBean(Dog.class));
//        System.out.println(context.getBeansOfType(Dog.class));
//        System.out.println(context.getBean(Dog.class));
//        context.getBean(Dog.class).show();

//        System.out.println(System.identityHashCode(123));

        context.getBeansOfType(Person.class).values().forEach(System.out::println);

        context.close();


    }
}
