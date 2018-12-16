package com.cmcm.study.concurrent.aqs;

/**
 * 模拟一个CAS算法，但是使用synchronized来实现，这是用java层面来实现，而真正操作系统的CAS不是通过这个来实现的
 */
public class CompareAndSwapDemo {

    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expected = compareAndSwap.get();
                boolean result = compareAndSwap.compareAndGet(expected, (int) (Math.random() * 101));
                System.out.println(result);
            }).start();
        }
    }
}

class CompareAndSwap {
    private int value;

    /** 获取 */
    public synchronized int get() {
        return value;
    }

    /** 比较 */
    public synchronized int compareAndSwap(int expected, int newValue) {
        int oldValue = value;
        if (oldValue == expected) {
            oldValue = newValue;
        }
        return oldValue;
    }

    /** 替换 */
    public synchronized boolean compareAndGet(int expected, int newValue) {
        return expected == compareAndSwap(expected, newValue);
    }
}
