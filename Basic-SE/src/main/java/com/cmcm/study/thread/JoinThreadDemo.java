package com.cmcm.study.thread;

/**
 * 来验证join方法保证线程的顺序执行
 */
public class JoinThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("1"));
        Thread t2 = new Thread(() -> System.out.println("2"));
        Thread t3 = new Thread(() -> System.out.println("3"));

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
}
