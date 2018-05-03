package com.cmcm.study;

import com.cmcm.study.bean.BeanConfig;
import com.cmcm.study.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class BasicSeApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(BasicSeApplication.class, args);
//	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanConfig.class);
		context.refresh();
		Student student = context.getBean(Student.class);
		System.out.println(student);
	}
}
