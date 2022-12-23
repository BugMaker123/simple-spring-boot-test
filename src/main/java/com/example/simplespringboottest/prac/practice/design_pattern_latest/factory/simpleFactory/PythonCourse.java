package com.example.simplespringboottest.prac.practice.design_pattern_latest.factory.simpleFactory;

/**
 * @ ClassName: PythonCourse
 * @Author: legen
 * @Date: 2021/4/23
 */
public class PythonCourse implements Icourse{
    @Override
    public Icourse createCourse() {
        System.out.println("生产了python课程");
        return new PythonCourse();
    }
}
