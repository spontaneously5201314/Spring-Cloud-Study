package com.cmcm.study.jvm;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 测试下指令重排序
 *
 * @author Spontaneously
 * @date 2018/11/20 19:55
 **/
public class OrderExample {

    private static int a = 0;
    private static boolean flag = false;

    private static final ExecutorService POOL = Executors.newCachedThreadPool();

//    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("current-%s").build();
//
//    private static final ExecutorService POOL = new ThreadPoolExecutor(
//            2, 10, 1000L, TimeUnit.SECONDS, new ArrayBlockingQueue<Order>(1024), threadFactory);

    private static void write() {
        a = 1;
        flag = true;
    }

    private static void read() {
        if (flag) {
            a = a + 1;
            flag = false;
        }
    }

    public static void main(String[] args) {
        POOL.submit(new Order());
    }

    static class Order implements Runnable{
        @Override
        public void run() {
            write();
            read();
        }
    }

}
