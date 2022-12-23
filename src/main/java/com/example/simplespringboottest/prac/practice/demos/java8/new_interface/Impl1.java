package com.example.simplespringboottest.prac.practice.demos.java8.new_interface;

/**
 * 实现类可以不实现任一方法,但是可以进行调用
 * @ ClassName: Impl1
 * @Author: legen
 * @Date: 2021/2/1
 */
public class Impl1 implements FunctionalDefaultMethods{
    @Override
    public void test(){
        getAge();
        FunctionalDefaultMethods.getName();
    }
}

class Test{
    public static void main(String[] args) {
        FunctionalDefaultMethods functionalDefaultMethods = new Impl1();
        functionalDefaultMethods.getAge();
        functionalDefaultMethods.test();
    }
}