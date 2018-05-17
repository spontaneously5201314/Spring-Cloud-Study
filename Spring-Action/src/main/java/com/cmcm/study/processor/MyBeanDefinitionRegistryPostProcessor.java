package com.cmcm.study.processor;

import com.cmcm.study.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * BeanDefinitionRegistryPostProcessor可以拿到BeanDefinitionRegistry和ConfigurableListableBeanFactory两个对象
 * BeanDefinitionRegistry可以动态的注入bean
 * @author hongfei
 * @create 2018-05-17 下午8:12
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        for (int i = 1; i <= 10; i++) {
            BeanDefinitionBuilder definition = BeanDefinitionBuilder.rootBeanDefinition(Person.class);
            definition.addPropertyValue("name", "person" + i);
            registry.registerBeanDefinition("person" + i, definition.getBeanDefinition());
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
