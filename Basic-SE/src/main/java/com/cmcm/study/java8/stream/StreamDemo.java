package com.cmcm.study.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * stream自己不会存储元素
 * stream不会改变源对象，相反，会返回一个持有结果的新的stream
 * stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。
 *
 * @author Spontaneously
 * @date 2018/10/15 16:11
 **/
public class StreamDemo {

    public static void main(String[] args) {
        //获取stream的四种方式
        //1、可以通过Collection系列集合提供的stream()或parallelStream()方法
        ArrayList<Integer> list = new ArrayList<>();
        Stream<Integer> stream1 = list.stream();

        //2、通过Arrays中的静态方法stream()获取数组流
        Integer[] integers = new Integer[]{};
        Stream<Integer> stream2 = Arrays.stream(integers);

        //3、通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("a", "b", "c");

        //4、创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(5).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);

        getDiv(new int[]{1, 2, 5, 4, 6, 3, 2});
    }

    private static final int[] getDiv(int[] ints) {


//        return Arrays.stream(ints).flatMap((num) -> {
//            return num++;
//        }).distinct().sorted().toArray();
        return null;
    }
}
