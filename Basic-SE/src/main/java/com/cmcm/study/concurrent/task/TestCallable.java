package com.cmcm.study.concurrent.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo threadDemo = new ThreadDemo();

        FutureTask<Integer> result = new FutureTask<>(threadDemo);

        new Thread(result).start();
        Thread.sleep(1000);
        if (result.isDone()) {
            System.out.println(result.get());
        }
    }

}

class ThreadDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}