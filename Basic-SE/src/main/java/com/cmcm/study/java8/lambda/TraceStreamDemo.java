package com.cmcm.study.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Spontaneously
 * @time 2018-10-16 下午6:48
 */
public class TraceStreamDemo {

    private static final List<String> LIST = new ArrayList<>();

    public static void main(String[] args) {
        LIST.add("red");
        LIST.add("blue");
        LIST.add("yellow");
        LIST.add("pink");
        LIST.add("green");
        LIST.add("black");
        LIST.add("white");

        List result = LIST.stream()
                .map(String::length)
                .filter(l -> l % 2 == 1)
                .collect(Collectors.toList());

        LIST.forEach(System.out::println);

        result.forEach(System.out::println);


    }
}
