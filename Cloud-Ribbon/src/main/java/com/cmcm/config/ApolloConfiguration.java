package com.cmcm.config;
//
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.spi.ConfigFactory;
//import com.ctrip.framework.apollo.spi.DefaultConfigFactoryManager;
//import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

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
