package com.cmcm.study.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * @author Spontaneously
 * @date 2018/11/25 20:48
 **/
@Service
public class UseSpringApplicationContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return new StringBuilder().append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 将继承此类的service中的字段（使用了@Autowired或者@Resource）等注入进来
     */
    public UseSpringApplicationContextAware() {
        if (this.applicationContext == null) {
            return;
        }

        if (this.getClass().isAnnotationPresent(Service.class) || this.getClass().isAnnotationPresent(Controller.class)
                || this.getClass().isAnnotationPresent(Component.class)) {
            return;
        }

        Class clazz = this.getClass();
        do {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class) || field.isAnnotationPresent(Resource.class)) {
                    try {
                        String simpleName = field.getType().getSimpleName();
                        String beanName = toLowerCaseFirstOne(simpleName);

                        Object bean = applicationContext.getBean(beanName);
                        if (bean == null) {
                            return;
                        }

                        boolean accessible = field.isAccessible();
                        field.setAccessible(true);
                        field.set(this, bean);
                        field.setAccessible(accessible);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
            clazz = clazz.getSuperclass();
        } while (clazz != Object.class);
    }
}
