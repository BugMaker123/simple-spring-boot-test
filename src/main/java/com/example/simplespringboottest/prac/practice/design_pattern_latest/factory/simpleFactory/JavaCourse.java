package com.example.simplespringboottest.prac.practice.design_pattern_latest.factory.simpleFactory;

/**
 * @ ClassName: JavaCourse
 * @Author: legen
 * @Date: 2021/4/23
 */
public class JavaCourse implements Icourse{
    private static JavaCourse instance = null;
    @Override
    public Icourse createCourse() {
        if (instance==null){
            System.out.println("create java course");
            return new JavaCourse();
        }else {
            return null;
        }
    }
}
