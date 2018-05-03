package com.cmcm.study.bean;

import com.cmcm.study.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongfei
 * @create 2018-05-03 下午2:59
 */
@Configuration
public class BeanConfig {

    @Bean
    public Student student(){
        return new Student("tom");
    }

}


