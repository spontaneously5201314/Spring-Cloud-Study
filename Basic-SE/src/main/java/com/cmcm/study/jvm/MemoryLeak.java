package com.cmcm.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己写一个内存泄漏的程序出来
 *
 * @author Spontaneously
 * @date 2018/11/18 11:45
 **/
public class MemoryLeak {

    private static List<int[]> bigIntObj = new ArrayList<>();

    private static List<char[]> bigCharObj = new ArrayList<>();

    public static int[] generate1M() {
        return new int[1024 * 256 * 2];
    }

    public static char[] generate1MChar() {
        return new char[1024 * 1024];
    }

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i < 1000) {
            if (i == 0) {
                Thread.sleep(5001);
                System.out.println("start = [ " + System.currentTimeMillis() + " ]");
            } else {
                Thread.sleep(4001);
            }
            bigIntObj.add(generate1M());
            i++;
        }
        System.in.read();
    }

}
