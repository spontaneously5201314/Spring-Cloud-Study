package com.cmcm.study.importer.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hongfei
 * @create 2018-05-22 下午2:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ContentConfiguration.class)
public @interface EnableContentService {

    public interface ContentService {
        void doSomething();
    }

    public class SimpleContentService implements ContentService {
        @Override
        public void doSomething() {
            System.out.println("do some simple things");
        }
    }
}
