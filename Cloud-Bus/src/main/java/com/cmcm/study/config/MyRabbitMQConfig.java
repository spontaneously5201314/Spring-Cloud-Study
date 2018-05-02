package com.cmcm.study.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongfei
 * @create 2018-04-26 下午4:29
 */
@Configuration
public class MyRabbitMQConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
