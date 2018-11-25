package com.cmcm.study.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Spontaneously
 * @date 2018/11/24 18:31
 **/
public class ArrayListConcurrentDemo {

    private static List<Integer> numberList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddToList(0));
        Thread t2 = new Thread(new AddToList(1));
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
            Thread.sleep(1);
        }
        System.out.println(numberList.size());
    }

    static class AddToList implements Runnable {

        private int startNum = 0;

        public AddToList(int startNum) {
            this.startNum = startNum;
        }

        @Override
        public void run() {
            int count = 0;
            while (count < 10000) {
                numberList.add(startNum);
                startNum += 2;
                count++;
            }
        }
    }
}
