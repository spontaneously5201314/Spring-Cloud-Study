package com.cmcm.study.jvm;

import java.util.HashMap;

/**
 * 测试在“-Xmx512M -Xms512M -XX:+UseSerialGC -Xloggc:gc.log -XX:+PrintGCDetails  -Xmn1m -XX:PretenureSizeThreshold=50 -XX:MaxTenuringThreshold=1”的JVM参数下，
 * 不断消耗内存，看GC的反应
 * @author Spontaneously
 * @date 2018/11/22 19:44
 **/
public class StopTheWorld {

    public static class PrintThread extends Thread {
        public static final long starttime = System.currentTimeMillis();

        @Override
        public void run() {
            try {
                while (true) {
                    long t = System.currentTimeMillis() - starttime;
                    System.out.println("time:" + t);
                    Thread.sleep(100);
                }
            } catch (Exception e) {

            }
        }
    }

    public static class MyThread extends Thread {
        HashMap<Long, byte[]> map = new HashMap<Long, byte[]>();

        @Override
        public void run() {
            try {
                while (true) {
                    if (map.size() * 512 / 1024 / 1024 >= 450) {
                        System.out.println("=====准备清理=====:" + map.size());
                        map.clear();
                    }

                    for (int i = 0; i < 1024; i++) {
                        map.put(System.nanoTime(), new byte[512]);
                    }
                    Thread.sleep(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
//        new PrintThread().start();
    }
}
