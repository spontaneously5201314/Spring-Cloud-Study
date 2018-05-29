package com.cmcm.config;
//
//importannotation com.ctrip.framework.apollo.Config;
//importannotation com.ctrip.framework.apollo.spi.ConfigFactory;
//importannotation com.ctrip.framework.apollo.spi.DefaultConfigFactoryManager;
//importannotation com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
//importannotation org.apache.commons.lang.StringUtils;
//importannotation org.slf4j.Logger;
//importannotation org.slf4j.LoggerFactory;
//importannotation org.springframework.beans.factory.annotation.Value;
//importannotation org.springframework.context.annotation.Bean;
//importannotation org.springframework.context.annotation.Configuration;

/**
 * @author hongfei
 * @create 2018-01-26 下午5:56
 */
//@Configuration
////@EnableApolloConfig
//public class ApolloConfiguration {
//
//    private static final Logger logger = LoggerFactory.getLogger(ApolloConfiguration.class);
//
//    @Value("${apollo.name.space:application}")
//    private String nameSpace;
//
//    @Bean
//    public ConfigFactory getConfigFactory() {
//        logger.info("before nameSpace {}", nameSpace);
//
//        DefaultConfigFactoryManager defaultConfigFactoryManager = new DefaultConfigFactoryManager();
//        ConfigFactory configFactory = defaultConfigFactoryManager.getFactory(nameSpace);
//        Config config = configFactory.create(nameSpace);
//        PropertyConfigurer.load(config);
//        return configFactory;
//    }
//
//}
