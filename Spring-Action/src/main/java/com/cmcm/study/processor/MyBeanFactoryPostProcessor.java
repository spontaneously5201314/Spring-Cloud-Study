package com.cmcm.study.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanFactoryPostProcessor只会在spring容器初始化之后触发，而且只会触发一次
 * @author hongfei
 * @create 2018-05-17 下午8:03
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("======BeanFactoryPostProcessor======" + beanFactory.getBeanDefinitionCount());
    }
}
