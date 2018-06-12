package com.cmcm.study.annotation;

import java.lang.annotation.*;

/**
 * 模拟注解
 *
 * @author hongfei
 * @create 2018-05-02 下午4:51
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.TYPE_PARAMETER})
@Inherited
public @interface MyAnnotation {

    String name() default "myAnnotation";
}
