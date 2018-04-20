package com.cmcm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * @author hongfei
 * @create 2018-04-20 下午3:20
 */
@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getContactPoints() {
        return "10.60.81.147";
    }

    @Override
    protected String getKeyspaceName() {
        return "arrow_brawl";
    }
}
