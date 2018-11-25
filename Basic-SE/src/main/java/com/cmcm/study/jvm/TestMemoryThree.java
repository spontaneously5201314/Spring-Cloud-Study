package com.cmcm.study.jvm;

import java.util.Vector;

/**
 * 通过加入-Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:+HeapDumpPath=error.dump参数
 * 来模拟jvm在超出堆使用的时候dump出来的情况，并分析dump出来的堆文件
 *
 * @author Spontaneously
 * @date 2018/11/21 20:53
 **/
public class TestMemoryThree {

    public static void main(String[] args) {
        Vector vector = new Vector();
        for (int i = 0; i < 25; i++) {
            vector.add(new byte[1024 * 1024]);
        }
    }
}
