package com.cmcm.study.java8.lambda;

import com.cmcm.study.java8.functional.MyFunctionalInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * @author Spontaneously
 * @time 2018-10-11 下午9:01
 */
public class LamdbaDemoOne {

    private static final List<Apple> LIST = new ArrayList<>(10);

    public static void main(String[] args) {
        LIST.add(new Apple("red", 10));
        LIST.add(new Apple("yellow", 101));
        LIST.add(new Apple("blue", 120));
        LIST.add(new Apple("pink", 20));
        LIST.add(new Apple("red", 30));
        LIST.add(new Apple("blue", 101));
        LIST.add(new Apple("yellow", 120));
        LIST.add(new Apple("red", 20));
        LIST.add(new Apple("blue", 30));

//        LIST.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getPrice() - o2.getPrice();
//            }
//        });

//        LIST.sort((Apple apple) -> Comparator.comparingInt(Apple::getPrice));

//        LIST.sort((Apple o1, Apple o2) -> o1.getPrice() - o2.getPrice());

        LIST.sort(comparingInt(Apple::getPrice));
        LIST.forEach(System.out::println);

        System.out.println("----------------------------------------------");

        LIST.sort(comparingInt(Apple::getPrice).reversed());
        LIST.forEach(System.out::println);

        System.out.println("----------------------------------------------");

        LIST.sort(comparingInt(Apple::getPrice).reversed().thenComparing(Apple::getColor));
        LIST.forEach(System.out::println);

        System.out.println("----------------------------------------------");
//        LIST.forEach(MyFunctionalInterface::hello);



    }
}
