package com.cmcm.study.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin extends RecursiveTask<Integer> {

    private static final int threshold = 2;
    private int start;
    private int end;

    public TestForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if (canCompute) {
            for (int i = start; i < end; i++) {
                sum *= i;
            }
        } else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            TestForkJoin leftTask = new TestForkJoin(start, middle);
            TestForkJoin rightTask = new TestForkJoin(middle + 1, end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        //生成一个计算任务，计算从1加到100的和
        TestForkJoin task = new TestForkJoin(1, 100);

        //执行一个任务
        ForkJoinTask<Integer> result = pool.submit(task);

        try {
            System.out.println("result: " + result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
