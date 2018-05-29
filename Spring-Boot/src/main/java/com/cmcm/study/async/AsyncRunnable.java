package com.cmcm.study.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author hongfei
 * @create 2018-05-22 下午2:40
 */
@Component
public class AsyncRunnable implements Runnable {

    @Async
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("=============" + i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
