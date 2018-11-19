package com.cmcm.study.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Spontaneously
 * @time 2018-11-06 下午3:47
 */
public class StreamDemoTwo {

    public static void main(String[] args) {
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<int[]> list = number1.stream().flatMap(integer -> number2.stream().map(j -> new int[]{integer, j})).collect(Collectors.toList());
        list.forEach(pair -> System.out.println(pair[0] + "--" + pair[1]));
    }
}
