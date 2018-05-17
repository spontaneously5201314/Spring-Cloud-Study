package com.cmcm.study.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author hongfei
 * @create 2018-05-17 下午4:22
 */
public class MyBean implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyBean is creating");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyBean is destroy");
    }
}
