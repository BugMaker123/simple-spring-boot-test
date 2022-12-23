package com.example.simplespringboottest.prac.practice.common;

/**
 * @ ClassName: AbstractFinalClass
 * @Author: legen
 * @Date: 2021/5/19
 */
public abstract class AbstractFinalClass {
    public static void main(String[] args) {
        System.out.println("abstract不支持final，final修饰变量，类，方法不可修改，abstract final class 无意义，就算可以也无法进行new操作");
    }
}
