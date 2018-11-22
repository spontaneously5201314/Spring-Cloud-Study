package com.cmcm.study.jvm;

/**
 * JVM参数-Xmx20m -Xms20m -Xmn15m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC
 * @author Spontaneously
 * @time 2018-11-21 下午8:17
 */
public class TestMemoryTwo {

    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            System.out.println("i========" + i);
            b = new byte[1024 * 1024];
        }
    }
}
