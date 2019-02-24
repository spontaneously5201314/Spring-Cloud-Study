package com.cmcm.study.java8.fork;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 尝试使用forkjoin
 * 使用forkjoin必须继承这个接口，然后自己写拆分任务的条件
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;

    private static final long THRESHOLD = 10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            //说明已经到了临界值，不能再拆分了
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            //说明还能拆分任务
            long middle = (start + end) / 2;

            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork();//拆分子任务，同事压入线程队列

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinCalculate forkJoinCalculate = new ForkJoinCalculate(0, 1000000000L);
        Long invoke = forkJoinPool.invoke(forkJoinCalculate);
        //775ms
        System.out.println(invoke + "and cost " + Duration.between(start, Instant.now()).toMillis() + "ms");
    }
}
