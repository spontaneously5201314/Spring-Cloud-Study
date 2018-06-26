package com.cmcm.study.annotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author Spontaneously
 * @time 2018-06-15 下午6:48
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(GenerateStudentCondition.class)
public @interface GenerateStudent {

    boolean value() default false;
}
