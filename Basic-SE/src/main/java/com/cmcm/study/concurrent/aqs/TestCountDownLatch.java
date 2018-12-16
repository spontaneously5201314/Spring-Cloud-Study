package com.cmcm.study.concurrent.aqs;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    private static CountDownLatch latch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(new LatchDemo(latch)).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("执行时间" + (end - start));
    }

}

class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 55000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }
    }
}
