package com.example.simplespringboottest.prac.practice.design_pattern.builder.demo;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/12/15
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director();

        director.construct();
        AbstractBuilder builder = new ConcreteBuilder();
        builder.buildGood(new Good("dog", "3000$", "white"));
        System.out.println(builder.getMarket().getGoodList());
    }
}
