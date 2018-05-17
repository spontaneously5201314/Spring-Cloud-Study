package com.cmcm.study.factory;

import com.cmcm.study.bean.Car;

/**
 * @author hongfei
 * @create 2018-05-17 下午4:58
 */
public class CarFactory {

    public Car create(){
        return new Car();
    }
}
