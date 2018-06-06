package com.cmcm.study.tomcat;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import java.io.File;

/**
 * 在SpringBoot中定制Tomcat的第二种方法
 * @author hongfei
 * @create 2018-06-06 下午3:22
 */
//@SpringBootConfiguration
public class TomcatConfiguration {

    private static final String PATH = "/opt/idea/workspace/Spring-Cloud-Study/Spring-Boot/src/main/resources/";

    @Bean
    public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory(){
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(10004);
        factory.setBaseDirectory(new File(PATH));
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        return factory;
    }
}
