package com.cmcm.study.annotation;

import com.cmcm.study.entity.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author hongfei
 * @create 2018-05-02 下午4:53
 */
@MyAnnotation(name = "MyAnnotationTest0000")
public class MyAnnotationTest {

    @MyAnnotation(name = "spon")
    private String name;

    @MyAnnotation(name = "main")
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        if(MyAnnotationTest.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation annotation = MyAnnotationTest.class.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.name());
        }
        if(MyAnnotationTest.class.getMethod("main", String[].class).isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation annotation = MyAnnotationTest.class.getMethod("main", String[].class).getAnnotation(MyAnnotation.class);
            System.out.println(annotation.name());
        }
        Field[] fields = MyAnnotationTest.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        if(MyAnnotationTest.class.getDeclaredField("name").isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation annotation = MyAnnotationTest.class.getDeclaredField("name").getAnnotation(MyAnnotation.class);
            System.out.println(annotation.name());
        }


        Annotation[] annotations = MyAnnotationInherited.class.getAnnotations();
        for (Annotation annotation : annotations){
            System.out.println(annotation.annotationType());
        }


        AnnotationTypeParm<Student> parm = new AnnotationTypeParm<>();
        System.out.println(parm.getValue().toString());
    }

}
