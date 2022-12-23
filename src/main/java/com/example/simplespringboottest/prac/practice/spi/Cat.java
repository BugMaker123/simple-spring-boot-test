package com.example.simplespringboottest.prac.practice.spi;

/**
 * @ ClassName: Cat
 * @Author: legen
 * @Date: 2021/2/2
 */
public class Cat implements Animal{

    @Override
    public String voice() {
        return "miumium";
    }
}
