package com.cmcm.study.stacktrace;

import java.util.Map;
import java.util.Set;

public class GetCurrentStackTrace {

    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Set<Thread> threadSet = allStackTraces.keySet();
        for (Thread thread : threadSet) {
            StackTraceElement[] stackTraceElements = allStackTraces.get(thread);
            for (StackTraceElement element : stackTraceElements) {
                System.out.println(element);
            }
        }
    }
}
