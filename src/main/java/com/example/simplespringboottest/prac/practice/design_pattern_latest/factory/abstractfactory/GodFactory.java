package com.example.simplespringboottest.prac.practice.design_pattern_latest.factory.abstractfactory;

/**
 * @ ClassName: GodeFactory
 * @Author: legen
 * @Date: 2021/4/25
 */
public class GodFactory extends God{
    @Override
    TigerFactory createTiger() {
        return new Tiger();
    }

    @Override
    HumanFactory createHuman() {
        return null;
    }
}
