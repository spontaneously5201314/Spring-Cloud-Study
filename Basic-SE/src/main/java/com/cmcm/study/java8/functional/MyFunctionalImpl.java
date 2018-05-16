package com.cmcm.study.java8.functional;

/**
 * @author hongfei
 * @create 2018-05-04 下午4:50
 */
public class MyFunctionalImpl implements MyFunctionalInterface<String>{

    public static void main(String[] args) {
        System.out.println(new MyFunctionalImpl().hello());
        System.out.println(new MyFunctionalImpl().say());
    }

    @Override
    public String say() {
        return "fuck";
    }

    @Override
    public boolean hello() {
        return false;
    }
}
