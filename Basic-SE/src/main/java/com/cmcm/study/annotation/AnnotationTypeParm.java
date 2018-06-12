package com.cmcm.study.annotation;

import com.cmcm.study.entity.Student;

/**
 * @author hongfei
 * @create 2018-06-11 上午11:22
 */
public class AnnotationTypeParm<T> {

    @SuppressWarnings("unchecked")
    public <T> T getValue() {
        return (T) new Student("AnnotationTypeParm");
    }
}
