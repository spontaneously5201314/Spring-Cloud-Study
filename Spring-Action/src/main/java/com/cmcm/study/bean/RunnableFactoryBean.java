package com.cmcm.study.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author hongfei
 * @create 2018-05-17 下午4:38
 */
public class RunnableFactoryBean implements FactoryBean<Runnable> {
    @Override
    public Runnable getObject() throws Exception {
        return () -> {
        };
    }

    @Override
    public Class<?> getObjectType() {
        return Runnable.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
