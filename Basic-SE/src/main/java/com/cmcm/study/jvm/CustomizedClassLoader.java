package com.cmcm.study.jvm;

/**
 * @author Spontaneously
 * @time 2018-11-19 上午11:03
 */
public class CustomizedClassLoader extends ClassLoader{

    protected CustomizedClassLoader() {
        super();
        System.out.println("调用了自定义的ClassLoader");
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
