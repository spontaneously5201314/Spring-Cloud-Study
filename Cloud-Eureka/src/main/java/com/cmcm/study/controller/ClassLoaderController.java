package com.cmcm.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * 用于给Basic-SE工程中的/opt/idea/workspace/Spring-Cloud-Study/Basic-SE/src/main/java/com/cmcm/study/jvm/ClassLoaderDemo.java做网络加载class使用
 * @author Spontaneously
 * @time 2018-11-19 上午11:18
 */
@RestController
public class ClassLoaderController {

    @GetMapping("/class")
    public String getDefaultClass(){
        File file = new File("../clazz/TestClassLoader.class");

        return null;
    }
}
