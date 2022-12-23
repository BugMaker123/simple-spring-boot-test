package com.example.simplespringboottest.prac.practice.design_pattern.decorator;

/**
 * @ ClassName: Coffee
 * @Author: legen
 * @Date: 2020/12/10
 */
public class Coffee implements Water{

    @Override
    public void drink() {
        System.out.println("drink coffee");
    }
}
