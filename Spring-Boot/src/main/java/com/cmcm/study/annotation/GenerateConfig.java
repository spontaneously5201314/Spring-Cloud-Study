package com.cmcm.study.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Spontaneously
 * @time 2018-06-15 下午6:53
 */
@Configuration
public class GenerateConfig {

    @Bean
    @GenerateStudent(true)
    public Student student() {
        return new Student(1, "Spontaneously", 20);
    }
}
