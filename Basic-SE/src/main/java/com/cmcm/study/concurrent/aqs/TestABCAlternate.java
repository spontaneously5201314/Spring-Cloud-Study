package com.cmcm.study.concurrent.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启三个线程，这三个线程的ID分别为A、B、C，每个线程间自己的ID在屏幕上打印10遍，
 * 要求输出结果必须是按照顺序输出，比如ABCABCABCABC.....
 */
public class TestABCAlternate {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition aCondition = lock.newCondition();
        Condition bCondition = lock.newCondition();
        Condition cCondition = lock.newCondition();
        for (int i = 0; i < 20;i++) {
//            aCondition.await();
//            new Thread(new Alternate("A")).start();
//            bCondition.signal();
//            bCondition.await();
//            new Thread(new Alternate("B")).start();
//            cCondition.signal();
//            cCondition.await();
//            new Thread(new Alternate("C")).start();
//            aCondition.signal();

            new Thread(new Alternate("A", aCondition)).start();
            new Thread(new Alternate("B", bCondition)).start();
            new Thread(new Alternate("C", cCondition)).start();
        }
    }

}
class Alternate implements Runnable{

    private String name;

    private Condition condition;

    public Alternate(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(name);
        condition.signal();
    }
}
