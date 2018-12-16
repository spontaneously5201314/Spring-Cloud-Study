package com.cmcm.study.concurrent.aqs;

import java.util.concurrent.*;

public class TestCyclicBarrier {

    private static final ExecutorService pool = Executors.newCachedThreadPool();

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            pool.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println(threadNum + "is ready");
        cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        System.out.println(threadNum + " continue");
    }
}
