package com.example.simplespringboottest.prac.practice.design_pattern.decorator;

/**
 * @ ClassName: Tea
 * @Author: legen
 * @Date: 2020/12/10
 */
public class Tea implements Water{
    @Override
    public void drink() {
        System.out.println("drink tea");
    }
}
