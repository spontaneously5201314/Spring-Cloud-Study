package com.cmcm.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongfei
 * @create 2018-06-07 下午4:49
 */
@Deprecated
@Configuration
public class MyRibbonConfig {

    @Autowired
    private IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new RandomRule();
    }

}
