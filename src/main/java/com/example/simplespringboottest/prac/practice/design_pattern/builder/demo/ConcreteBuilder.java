package com.example.simplespringboottest.prac.practice.design_pattern.builder.demo;

/**
 * @ ClassName: ConcreteBuilder
 * @Author: legen
 * @Date: 2020/12/15
 */
public class ConcreteBuilder extends AbstractBuilder {

    private Market market = new Market();

    @Override
    void buildGood(Good good) {
        market.addGood(good);
    }

    @Override
    Market getMarket() {
        return market;
    }
}
