package com.example.simplespringboottest.prac.practice.spi;

/**
 * @ ClassName: Dog
 * @Author: legen
 * @Date: 2021/2/2
 */
public class Dog implements Animal{
    @Override
    public String voice() {
        return "wawawa";
    }
}
