package com.cmcm.study.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Spontaneously
 * @time 2018-06-25 下午4:04
 */
public class ReflectTest {

    public void say(String name){
        System.out.println(name);
    }


    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object instance = Class.forName(ReflectTest.class.getName()).newInstance();
        Method say = instance.getClass().getMethod("say", String.class);
        say.invoke(instance, "spontaneously");
    }
}
