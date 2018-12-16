package com.cmcm.study.concurrent.task;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class TestFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> result = pool.submit(new MyCallable());
        sleep(1000);
        System.out.println("query time is " + System.nanoTime());
        String query = result.get();
        System.out.println("query is " + query + ", time is " + System.nanoTime());
    }


    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("do something");
            sleep(5000);
            return "OK";
        }
    }
}
