package com.cmcm.study.reflect.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ConstructorDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.lang.String");
//        Constructor<?>[] constructors = aClass.getConstructors();
//        for (Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.print(Modifier.toString(method.getModifiers()) + "-->" + method.getName()
                    + "-->" + method.getReturnType().getSimpleName() + "(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length > 0) {
                for (Class parameter : parameterTypes) {
                    System.out.print(parameter.getSimpleName());
                }
            }
            System.out.println(")");
        }
    }
}
