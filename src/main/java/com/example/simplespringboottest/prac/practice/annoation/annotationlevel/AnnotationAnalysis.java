package com.example.simplespringboottest.prac.practice.annoation.annotationlevel;

import com.example.simplespringboottest.prac.first.base.Children;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

/**
 * @ ClassName: AnnoationAnlysis
 * @Author: legen
 * @Date: 2021/3/25
 */
public class AnnotationAnalysis {
    public static void main(String[] args) {
        JsonFormat annotation = User.class.getAnnotation(JsonFormat.class);
        Class<? extends JsonFormat> aClass = annotation.getClass();

        Component annotation1 = Children.class.getAnnotation(Component.class);

    }
}
