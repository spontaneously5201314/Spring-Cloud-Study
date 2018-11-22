package com.cmcm.study.jvm;

/**
 * 通过-Xmx和-Xms来调整堆的大小，并通过Runtime类来获得jvm运行期间的使用的堆的大小
 *
 * @author Spontaneously
 * @time 2018-11-21 下午8:03
 */
public class TestMemory {

    public static void main(String[] args) {
        byte[] b1 = new byte[1024 * 1024];
        byte[] b2 = new byte[4 * 1024 * 1024];
        System.gc();
        System.out.println("最大=" + (Runtime.getRuntime().maxMemory() / 1024.0 / 1024) + "M");
        System.out.println("空闲=" + (Runtime.getRuntime().freeMemory() / 1024.0 / 1024) + "M");
        System.out.println("总共=" + (Runtime.getRuntime().totalMemory() / 1024.0 / 1024) + "M");
    }
}
