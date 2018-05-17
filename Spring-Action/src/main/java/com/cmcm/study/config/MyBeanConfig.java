package com.cmcm.study.config;

import com.cmcm.study.bean.Car;
import com.cmcm.study.bean.Dog;
import com.cmcm.study.bean.MyBean;
import com.cmcm.study.bean.RunnableFactoryBean;
import com.cmcm.study.factory.CarFactory;
import org.springframework.context.annotation.*;

/**
 * @author hongfei
 * @create 2018-05-17 下午4:22
 */
@ComponentScan(value = "com.cmcm.study", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Dog.class))
@Configuration
public class MyBeanConfig {

    @Bean
    public CarFactory createFactory() {
        return new CarFactory();
    }

    @Bean("myBean")
    @Scope("prototype")
    public MyBean getMyBean() {
        return new MyBean();
    }

    @Bean
    public RunnableFactoryBean createRunnableFactoryBean() {
        return new RunnableFactoryBean();
    }

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car createCar(CarFactory factory) {
        return factory.create();
    }

    @Bean
    public Dog createDog() {
        return new Dog();
    }

}
