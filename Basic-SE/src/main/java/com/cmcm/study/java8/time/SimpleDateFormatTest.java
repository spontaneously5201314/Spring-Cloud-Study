package com.cmcm.study.java8.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class SimpleDateFormatTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(() -> sdf.parse("20180228")));
        }
        for (Future<Date> result : results) {
            System.out.println(result.get());
        }
//        results.stream().map(future -> future.get()).forEach(System.out::println);
    }
}
