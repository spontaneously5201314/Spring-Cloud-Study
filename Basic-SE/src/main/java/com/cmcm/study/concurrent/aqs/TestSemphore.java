package com.cmcm.study.concurrent.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemphore {

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            pool.execute(() -> {
                try {
                    if (semaphore.tryAcquire()){
                        test(threadNum);
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("finish");
        pool.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("current thread is " + threadNum + ", and current time is " + System.nanoTime());
    }
}
