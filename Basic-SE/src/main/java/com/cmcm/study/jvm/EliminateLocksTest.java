package com.cmcm.study.jvm;

/**
 * 测试锁消除对于程序性能的影响
 * 分别在锁消除（-server -XX:+DoEscapeAnalysis -XX:+EliminateLocks）和不消除（-server -XX:+DoEscapeAnalysis -XX:-EliminateLocks）的情况下测试
 * 测试结果，在锁消除的情况下是159ms，不消除的情况下是209ms
 * 但是一定要记得在做锁消除的时候一定要配合使用逃逸分析，因为只有在保证使用到的变量是在栈中的，而且不会逃逸，才可以使用锁消除而不会导致并发问题
 *
 * @author Spontaneously
 * @date 2018/11/25 13:31
 **/
public class EliminateLocksTest {

    private static final int CIRCLE = 2000000;

//    private static StringBuffer sb = null;//267/232

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            createStringBuffer("JVM", "Diagnosis");
        }
        long bufferCost = System.currentTimeMillis() - start;
        System.out.println("createStringBuffer: " + bufferCost + " ms");
    }

    private static String createStringBuffer(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }

}
