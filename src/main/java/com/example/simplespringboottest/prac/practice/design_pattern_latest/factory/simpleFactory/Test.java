package com.example.simplespringboottest.prac.practice.design_pattern_latest.factory.simpleFactory;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2021/4/23
 */
public class Test {
    public static void main(String[] args) {
        IcourseFactory icourseFactory = new IcourseFactory();
        Icourse java = icourseFactory.getIcourse("java");
        Icourse course = java.createCourse();

        Icourse python = icourseFactory.getIcourse("python");
        Icourse pythonCourse = python.createCourse();
    }
}
