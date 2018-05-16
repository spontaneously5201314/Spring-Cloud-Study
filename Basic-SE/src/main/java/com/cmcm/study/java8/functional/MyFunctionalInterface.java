package com.cmcm.study.java8.functional;

/**
 * @author hongfei
 * @create 2018-05-04 下午4:47
 */
@FunctionalInterface
public interface MyFunctionalInterface<A> {

    default A say(){
        return null;
    }

    boolean hello();

    boolean equals(Object object);
}
