package com.cmcm.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

/**
 * @author hongfei
 * @create 2018-05-18 下午3:32
 */
@Configuration
//@PropertySource(value = "classpath:jdbc.properties")
//@PropertySource(value = "classpath:orm.properties")
//@PropertySources({@PropertySource(value = "classpath:jdbc.properties"), @PropertySource(value = "classpath:orm.properties")})
public class MyConfig {

    @Autowired
    private Environment environment;

//    @Value("${name}")
//    private String name;

    public void show() {
        System.out.println(environment.getProperty("spring.profiles.active"));
        String[] activeProfiles = environment.getActiveProfiles();
        for (String profile : activeProfiles) {
            System.out.println(profile);
        }
        String[] defaultProfiles = environment.getDefaultProfiles();
        for (String profile : defaultProfiles) {
            System.out.println(profile);
        }
    }
}
