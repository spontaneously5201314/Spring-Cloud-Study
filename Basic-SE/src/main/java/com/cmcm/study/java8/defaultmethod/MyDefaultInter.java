package com.cmcm.study.java8.defaultmethod;

/**
 * @author hongfei
 * @create 2018-05-04 下午3:12
 */
public interface MyDefaultInter {

    default String say(){
        return "hello";
    }
}
