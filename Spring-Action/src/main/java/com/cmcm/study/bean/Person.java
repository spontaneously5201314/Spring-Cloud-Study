package com.cmcm.study.bean;

/**
 * @author hongfei
 * @create 2018-05-17 下午8:13
 */
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
