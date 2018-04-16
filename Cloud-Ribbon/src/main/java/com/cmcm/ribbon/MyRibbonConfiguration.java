package com.cmcm.ribbon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongfei
 * @create 2018-03-20 下午5:42
 */
@Configuration
public class MyRibbonConfiguration {

    @Bean
    public IPing ribbonPing(){
        return new PingUrl();
    }

}
