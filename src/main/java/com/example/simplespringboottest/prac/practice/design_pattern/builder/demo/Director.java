package com.example.simplespringboottest.prac.practice.design_pattern.builder.demo;

/**
 * @ ClassName: Director
 * @Author: legen
 * @Date: 2020/12/15
 */
public class Director {
    private AbstractBuilder builder = new ConcreteBuilder();
    public void construct(){
        builder.buildGood(new Good());
    }
}
