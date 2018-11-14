package com.cmcm.study.java8.lambda.consumer;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

/**
 * @author Spontaneously
 * @time 2018-10-13 下午2:12
 */
public class MyBIConsumer {

    private static final Map<String, Integer> MAP = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        MAP.put("blue", 1);
        MAP.put("yellow", 2);
        MAP.put("red", 3);
        MAP.put("white", 4);
        MAP.put("black", 5);

//        MAP.forEach();

    }
}
