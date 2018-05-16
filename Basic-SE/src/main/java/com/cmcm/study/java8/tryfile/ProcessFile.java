package com.cmcm.study.java8.tryfile;

import java.io.*;

/**
 * @author hongfei
 * @create 2018-05-04 下午5:45
 */
public class ProcessFile {

    private static void processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/opt/idea/workspace/Spring-Cloud-Study/Basic-SE/src/main/java/com/cmcm/study/java8/defaultmethod/MyDefaultImpl.java"))) {
            System.out.println(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        processFile();

        try (
                // 声明、初始化两个可关闭的资源
                BufferedReader br = new BufferedReader(new FileReader(
                        "ProcessFile.java"));
                PrintStream ps = new PrintStream(new FileOutputStream(
                        "ProcessFile.java"))) {
            // 使用两个资源
            System.out.println(br.readLine());
            ps.println("test");
        }
        // 自动关闭资源的try语句相当于包含了隐式的finally块，用于关闭资源。
    }
}
