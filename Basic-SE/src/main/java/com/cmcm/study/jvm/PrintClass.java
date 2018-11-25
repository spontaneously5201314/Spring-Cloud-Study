package com.cmcm.study.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 尝试打印出class文件的十六进制
 *
 * @author Spontaneously
 * @date 2018/11/25 15:40
 **/
public class PrintClass {

    public static void main(String[] args) {
        File file = new File("D:\\WorkSpace\\IdeaProjects\\Spring-Cloud-Study\\Basic-SE\\target\\classes\\com\\cmcm\\study\\jvm\\CanReliveObj.class");
        try {
            FileInputStream stream = new FileInputStream(file);
            if (stream.available() > 0) {
                int read = stream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
