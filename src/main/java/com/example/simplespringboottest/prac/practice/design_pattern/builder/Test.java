package com.example.simplespringboottest.prac.practice.design_pattern.builder;

import java.util.List;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/12/15
 */
public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        director.construct(builder);
        SuperMarket superMarket = builder.getResult();
        List<String> show = superMarket.show();
        for (int i = 0; i < show.size(); i++) {
            System.out.println(show.get(i));
        }
    }
}
