package com.cmcm.study.proxy;

/**
 * 测试ProxyUtils中对于字节码的操作
 * @author Spontaneously
 * @date 2018/11/27 16:55
 **/
public class ProxyTest {

    private String name;

    private int age;

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
