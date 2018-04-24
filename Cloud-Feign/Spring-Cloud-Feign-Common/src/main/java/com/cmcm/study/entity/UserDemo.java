package com.cmcm.study.entity;

import java.io.Serializable;

/**
 * @author hongfei
 * @create 2018-04-20 下午5:46
 */
public class UserDemo implements Serializable{

    private int id;

    private String name;

    private int age;

    public UserDemo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
