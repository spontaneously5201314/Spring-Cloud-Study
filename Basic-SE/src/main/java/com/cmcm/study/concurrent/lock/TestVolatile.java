package com.cmcm.study.concurrent.lock;

public class TestVolatile {

    public static void main(String[] args) {
        DemoThread dt = new DemoThread();
        new Thread(dt).start();
        while (true) {
            if (dt.isFlag()) {
                System.out.println("----------------");
                break;
            }
        }
    }

}

class DemoThread implements Runnable {

    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}