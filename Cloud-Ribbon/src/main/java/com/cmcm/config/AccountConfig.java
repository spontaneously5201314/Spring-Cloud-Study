package com.cmcm.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author hongfei
 * @create 2018-04-17 下午8:34
 */
@Configuration
@EnableApolloConfig(value = "account", order = Ordered.HIGHEST_PRECEDENCE)
public class AccountConfig {
}
