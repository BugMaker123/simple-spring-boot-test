package com.example.simplespringboottest.prac.practice.design_pattern.builder;

/**
 * @ ClassName: ConcreateBuilder
 * @Author: legen
 * @Date: 2020/12/15
 */
public class ConcreteBuilder extends Builder{
    private SuperMarket superMarket = new SuperMarket();

    @Override
    void buildA() {
        superMarket.add("A");
    }

    @Override
    void buildB() {
        superMarket.add("B");
    }

    @Override
    void buildC() {
        superMarket.add("C");
    }

    @Override
    SuperMarket getResult() {
        return superMarket;
    }
}
