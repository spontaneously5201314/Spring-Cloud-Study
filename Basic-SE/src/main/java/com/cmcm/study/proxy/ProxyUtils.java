package com.cmcm.study.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Spontaneously
 * @date 2018/11/27 16:48
 **/
public class ProxyUtils {

    /**
     * 将根据类信息动态生成的二进制字节码保存到硬盘中，默认的是clazz目录下params
     *
     * @param clazz     需要生成动态代理类的类
     * @param proxyName 为动态生成的代理类的名称
     */
    public static void generateClassFile(Class clazz, String proxyName) {
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, new Class[]{clazz});

//        String paths = clazz.getResource(".").getPath();
        String paths = "D:\\WorkSpace\\IdeaProjects\\Spring-Cloud-Study\\Basic-SE\\src\\main\\java\\com\\cmcm\\study\\proxy";
        System.out.println(paths);
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(paths + proxyName + ".class");
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        generateClassFile(ProxyTest.class, ProxyTest.class.getSimpleName());
    }
}
