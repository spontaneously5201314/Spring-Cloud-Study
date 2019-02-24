package com.cmcm.study.java8.defaultmethod;

/**
 * @author hongfei
 * @create 2018-05-04 下午3:13
 */
public class MyDefaultImpl implements MyDefaultInter {

    public static void main(String[] args) {
        MyDefaultImpl myDefault = new MyDefaultImpl();
        System.out.println(myDefault.say());
    }

}
