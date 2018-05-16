package com.cmcm.study;

import com.cmcm.study.java8.defaultmethod.MyDefaultImpl;

//@SpringBootApplication
public class BasicSeApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(BasicSeApplication.class, args);
//	}

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(BeanConfig.class);
//		context.refresh();
//		Student student = context.getBean(Student.class);
//		System.out.println(student);

		System.out.println(new MyDefaultImpl().say());
	}
}
