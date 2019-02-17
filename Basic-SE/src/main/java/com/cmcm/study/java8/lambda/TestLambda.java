package com.cmcm.study.java8.lambda;

import java.util.TreeSet;

public class TestLambda {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>((x, y) -> Integer.compare(x, y));
    }

}
