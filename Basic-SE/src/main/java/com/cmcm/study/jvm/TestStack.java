package com.cmcm.study.jvm;

/**
 * 主要测试栈上分配和堆上分配对象的区别
 * 分别使用JVM参数为
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC
 * -server -Xmx10m -Xms10m -XX:-DoEscapeAnalysis -XX:+PrintGC
 *
 * @author Spontaneously
 * @date 2018/11/20 17:52
 **/
public class TestStack {

    private static final int COUNT = 100000000;

    private static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}
