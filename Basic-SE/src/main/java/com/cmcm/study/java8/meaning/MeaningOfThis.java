package com.cmcm.study.java8.meaning;

/**
 * @author hongfei
 * @create 2018-05-04 下午3:42
 */
public class MeaningOfThis {

    private final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis aThis = new MeaningOfThis();
        aThis.doIt();
    }
}
