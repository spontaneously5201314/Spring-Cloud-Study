package com.cmcm.study.reflect.invocation;

/**
 * @author Spontaneously
 * @time 2018-11-22 上午11:29
 */
public class HelloImpl implements Hello {

    private volatile String infos1;

    private volatile String infos2;

    @Override
    public String getInfos1() {
        return infos1;
    }

    @Override
    public String getInfos2() {
        return infos2;
    }

    @Override
    public void setInfo(String infos1, String infos2) {
        this.infos1 = infos1;
        this.infos2 = infos2;
    }

    @Override
    public void display() {
        System.out.println("\t\t" + infos1 + "\t" + infos2);
    }
}
