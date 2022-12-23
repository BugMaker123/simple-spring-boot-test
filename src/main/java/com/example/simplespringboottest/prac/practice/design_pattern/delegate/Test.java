package com.example.simplespringboottest.prac.practice.design_pattern.delegate;


import com.example.simplespringboottest.prac.practice.design_pattern.adapt.HumanService;
import com.example.simplespringboottest.prac.practice.design_pattern.adapt.ManServiceImpl;
import com.example.simplespringboottest.prac.practice.design_pattern.adapt.WomanServiceImpl;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/12/10
 */
public class Test {
    private static int man = 1;
    private static int woman = 2;

    public static HumanService getService(int type){
        HumanService humanService = null;
        if (man==type){
            humanService = new ManServiceImpl();
        }else {
            humanService = new WomanServiceImpl();
        }
        return humanService;
    }

    public static void main(String[] args) {
        getService(1).eatFood();
        getService(2).eatFood();
    }
}
