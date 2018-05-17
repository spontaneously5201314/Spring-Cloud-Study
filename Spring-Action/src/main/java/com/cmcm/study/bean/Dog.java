package com.cmcm.study.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author hongfei
 * @create 2018-05-17 下午5:14
 */
@Component
//@Repository
//@Service
//@Controller
public class Dog {

//    @Resource
    @Inject
    private Car car;

    @Autowired
    private ApplicationContext applicationContext;

    public void show(){
        System.out.println(applicationContext);
    }

//    @PostConstruct
//    public void init(){
//        System.out.println("dog init");
//    }
//
//    @PreDestroy
//    public void close(){
//        System.out.println("dog close");
//    }


    @Override
    public String toString() {
        return "Dog{" +
                "car=" + car +
                '}';
    }
}
