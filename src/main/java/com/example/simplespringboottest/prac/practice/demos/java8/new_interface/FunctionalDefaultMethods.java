package com.example.simplespringboottest.prac.practice.demos.java8.new_interface;

/**
 * @ ClassName: FunctionalDefaultMethods
 * @Author: legen
 * @Date: 2021/2/1
 */
public interface FunctionalDefaultMethods {
    static void getName(){
        System.out.println("his name is Tom");
    }
    default void getAge(){
        System.out.println("his age is 23");
    }
    void test();
}
