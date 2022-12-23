package com.example.simplespringboottest.prac.practice.annoation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @ ClassName: NotNullImpl
 * @Author: legen
 * @Date: 2021/1/25
 */
public class NotNullImpl {
    public static void validateParam(){
        Field[] fields = Object.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            Annotation[] annotations = field.getAnnotations();
            for (int j = 0; j < annotations.length; j++) {
                if (annotations[j].annotationType().isAnnotationPresent(NotNull.class)){

                }
            }
        }
    }
}
