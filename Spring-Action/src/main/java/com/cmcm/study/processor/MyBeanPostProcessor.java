package com.cmcm.study.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author hongfei
 * @create 2018-05-17 下午7:32
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    /**
     * 实在bean依赖装配(属性设置完)完成之后触发，这里可以对指定的bean做一些处理，比如返回该对象的代理对象
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=============postProcessBeforeInitialization============" + beanName);
        return bean;
    }

    /**
     * 是在bean init方法执行之后触发的
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=============postProcessAfterInitialization============" + beanName);
        return bean;
    }
}
