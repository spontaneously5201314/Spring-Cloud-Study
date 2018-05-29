package com.cmcm.study.condition;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration和SpringBootConfiguration效果是一样的
 * @author hongfei
 * @create 2018-05-21 下午6:48
 */
//@Configuration
@SpringBootConfiguration
public class MyConditionConfig {

    /**
     * Conditional指满足某个条件的注解会生效，会注入这些bean,可以放在类上，也可以放在方法上，放在类上，表示类中的bean都会注入
     * 而且参数是数组，表示数组中的条件都满足，才会注入
     * @return
     */
    @Bean
    @Conditional(MyCondition.class)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
