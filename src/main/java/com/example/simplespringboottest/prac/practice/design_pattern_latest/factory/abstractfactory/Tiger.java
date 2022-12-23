package com.example.simplespringboottest.prac.practice.design_pattern_latest.factory.abstractfactory;

/**
 * @ ClassName: Tiger
 * @Author: legen
 * @Date: 2021/4/25
 */
public class Tiger extends TigerFactory{
    static TigerFactory createTiger(String name){
        return new Tiger();
    }
}
