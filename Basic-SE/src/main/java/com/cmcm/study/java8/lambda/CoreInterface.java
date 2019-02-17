package com.cmcm.study.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Java8内置了4大函数式接口
 * Consumer<T> 消费型接口
 *          void accept(T t)
 * Supplier<T> 供给型接口
 *          T get()
 * Function<T, R> 函数型接口
 *          R apply(T t)
 * Predicate<T> 断言型接口
 *          boolean test(t)
 */
public class CoreInterface {

    public static void main(String[] args) {
        List<Integer> numberList = getNumberList(10, () -> new Random(9).nextInt());
        System.out.println(numberList);
    }

    public static List<Integer> getNumberList(int num, Supplier<Integer> supplier){
        List<Integer> result = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            Integer temp = supplier.get();
            result.add(temp);
        }
        return result;
    }
}
