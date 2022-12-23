package com.example.simplespringboottest.prac.practice.design_pattern.prototype;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/12/16
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cache.loadCache();
        Parent childA = Cache.getShape("child A");
        System.out.println(childA.toString());
        childA.eat();
        System.out.println("================================");
    }
}
