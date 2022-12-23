package com.example.simplespringboottest.prac.practice.annoation;

import java.lang.annotation.*;

/**
 * @ ClassName: NotNull
 * @Author: legen
 * @Date: 2021/1/25
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
     String message() default "";
}
