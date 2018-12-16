package com.cmcm.study.concurrent.lock;

import java.util.List;
import java.util.Vector;

/**
 * 分别测试在开启（-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0）偏向锁和不开启（-XX:-UseBiasedLocking）的情况下的时间
 * 注意开启情况下后面跟的BiasedLockingStartupDelay参数表示在一开始就启动偏向锁，因为在JVM在设计的时候，默认系统一开始是不适用偏向锁，等过几秒才开启偏向锁
 * 测试结果是前者419，否则570，所以开启偏向锁是会快一些
 * @author Spontaneously
 * @date 2018/11/24 18:46
 **/
public class BasicLocking {

    public static List<Integer> numberList = new Vector<Integer>();

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while (count < 10000000) {
            numberList.add(startnum);
            startnum += 2;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

}
