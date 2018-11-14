package com.cmcm.study.java8.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Spontaneously
 * @time 2018-10-21 上午11:53
 */
public class CompletableFutureDemo {

    private static final int TOTAL_NUM = 10;

    private static final Executor SERVICE = Executors.newFixedThreadPool(Math.min(TOTAL_NUM, 100),
            (Runnable runnable) -> {
                Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                return thread;
            });

    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_NUM; i++) {
            long startTime = System.currentTimeMillis();
//            double price = getPrice();
            double price = 0;
            try {
                price = getPriceAsyncTwo().get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("本次调用返回的price=" + price + ",耗时" + (System.currentTimeMillis() - startTime));
            System.out.println("-----------------------------------");
        }
    }

    private static double getPrice() {
        return calculatePrice();
    }

    private static Future<Double> getPriceAsyncTwo() {
        return CompletableFuture.supplyAsync(CompletableFutureDemo::calculatePrice, SERVICE);
    }

    private static Future<Double> getPriceAsyncOne() {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice();
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    private static double calculatePrice() {
        delay();
        return new Random().nextDouble();
    }

    private static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
