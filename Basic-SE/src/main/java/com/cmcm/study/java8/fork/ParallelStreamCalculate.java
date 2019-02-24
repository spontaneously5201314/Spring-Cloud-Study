package com.cmcm.study.java8.fork;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

public class ParallelStreamCalculate {

    @Test
    public void testParallel() {
        Instant start = Instant.now();
        long sum = LongStream.rangeClosed(0, 1000000000L).parallel().reduce(0, Long::sum);
        System.out.println(sum + "and cost " + Duration.between(start, Instant.now()).toMillis() + "ms");
    }

}
