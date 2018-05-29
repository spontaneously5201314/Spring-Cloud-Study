package com.cmcm.study.registry;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.stereotype.Component;

/**
 * @author hongfei
 * @create 2018-05-22 下午3:22
 */
@Component
public class MyBeanDefinitionRegistry extends SimpleBeanDefinitionRegistry {

    static final String beanName = "AsyncRunnable";

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException {
        boolean asyncRunnable = containsBeanDefinition("AsyncRunnable");
        System.out.println("是否包含\"AsyncRunnable\"" + asyncRunnable);

        super.registerBeanDefinition(beanName, beanDefinition);
    }
}
