package com.example.simplespringboottest.prac.practice.design_pattern_latest.factory.simpleFactory;

/**
 * @ ClassName: IcourseFactory
 * @Author: legen
 * @Date: 2021/4/23
 */
public class IcourseFactory {

    public Icourse getIcourse(String name) {
       switch (name){
           case "java":
               return new JavaCourse();
           case "python":
               return new PythonCourse();
           default:
               return null;
       }
    }
}
