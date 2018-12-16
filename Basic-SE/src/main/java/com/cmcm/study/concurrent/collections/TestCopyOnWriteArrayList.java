package com.cmcm.study.concurrent.collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(helloThread).start();
        }
    }

}

class HelloThread implements Runnable {

    //    使用这种方式会发生ConcurrentModificationException异常
//    private static List<String> list = Collections.synchronizedList(new ArrayList<>());
//
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add("DD");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            list.add("A");
            System.out.println(iterator.next());
        }
    }
}
