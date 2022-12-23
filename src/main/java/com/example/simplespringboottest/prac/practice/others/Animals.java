package com.example.simplespringboottest.prac.practice.others;

import lombok.Data;

/**
 * @ ClassName: Animal
 * @Author: legen
 * @Date: 2021/4/8
 */
@Data
public class Animals {
    private String name;
    private Integer age;

    public void getAnswer(){
        System.out.println("this is parent");
    }
}

