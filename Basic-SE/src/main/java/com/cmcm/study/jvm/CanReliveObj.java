package com.cmcm.study.jvm;

/**
 * @author Spontaneously
 * @date 2018/11/22 17:13
 **/
public class CanReliveObj {
    public static CanReliveObj obj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj();
        //可复活
        obj = null;
        System.out.println("开始调用第一次gc");
        System.gc();
        System.out.println("结束调用第一次gc");
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj 是 null");
        } else {
            System.out.println("obj 可用");
        }
        System.out.println("第二次gc");
        //不可复活
        obj = null;
        System.out.println("开始调用第二次gc");
        System.gc();
        System.out.println("结束调用第二次gc");
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj 是 null");
        } else {
            System.out.println("obj 可用");
        }
    }
}
