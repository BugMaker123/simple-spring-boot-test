package com.example.simplespringboottest.prac.practice.design_pattern.builder;

/**
 * @ ClassName: Director
 * @Author: legen
 * @Date: 2020/12/15
 */
public class Director {
    public void construct(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
    }
}
