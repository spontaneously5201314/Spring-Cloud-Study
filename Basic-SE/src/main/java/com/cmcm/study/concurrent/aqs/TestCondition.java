package com.cmcm.study.concurrent.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 验证下使用了Condition的情况下，线程的执行顺序
 */
public class TestCondition {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("wait signal");//1
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("get signal");//4
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            System.out.println("get lock");//2
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println("send signal");//3
            lock.unlock();
        }).start();
    }
}
