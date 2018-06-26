package com.cmcm.study.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author Spontaneously
 * @time 2018-06-15 下午6:50
 */
public class GenerateStudentCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(GenerateStudent.class.getName());
        return (boolean) attributes.get("value");
    }
}
