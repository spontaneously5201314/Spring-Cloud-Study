package com.cmcm.study.jvm;

import org.apache.commons.lang3.StringUtils;
import sun.misc.Launcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 验证Java中使用的ClassLoader
 * 在JVM参数中加入-verbose可以看到JVM启动时候加载了哪些类
 * @author Spontaneously
 * @time 2018-11-19 上午10:52
 */
public class ClassLoaderDemo {

    private static final String COMMA = ":";

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        //获取加载的BootStrap ClassLoader，其中通过Launcher.getBootstrapClassPath().getURLs()和通过System.getProperty("sun.boot.class.path")是相同的
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
//        for (URL url : urLs) {
//            System.out.println(url.toExternalForm());
//        }
        System.out.println("--------------------------------------");
        String property = System.getProperty("sun.boot.class.path");
//        if (property != null && property.contains(COMMA)) {
//            String[] libs = StringUtils.split(property, COMMA);
//            for (String libPath : libs) {
//                System.out.println(libPath);
//            }
//        }

        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

//        URL[] urls = new URL[]{new URL("http", "localhost", 8080, "/class")};
//        URLClassLoader loader = new URLClassLoader(urls);
//        Class<?> aClass = loader.loadClass("testClassLoader.class");
//        System.out.println(aClass);

        System.out.println("--------------------------------------");
        //测试ClassLoader的加载体系
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        while (classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }

        System.out.println(ClassLoaderDemo.class.toGenericString());
    }
}
