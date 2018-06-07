package com.cmcm.study.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author hongfei
 * @create 2018-06-07 下午2:45
 */
@Aspect
@Component
public class MyAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.cmcm.study.controller..*.*(..))")
    public void log() {
        System.out.println("调用了AOP编程");
    }

}
