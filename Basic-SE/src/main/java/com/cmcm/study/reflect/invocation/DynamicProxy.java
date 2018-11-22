package com.cmcm.study.reflect.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试类
 * @author Spontaneously
 * @time 2018-11-22 上午11:31
 */
public class DynamicProxy {

    public static Object getBean(String className) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        Object obj = Class.forName(className).newInstance();
        InvocationHandler handler = new AOPFactory(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
                .getClass().getInterfaces(), handler);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            Hello hello = (Hello) getBean("com.cmcm.study.reflect.invocation.HelloImpl");
            hello.setInfo("xieyu1", "xieyu2");
            hello.getInfos1();
            hello.getInfos2();
            hello.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
