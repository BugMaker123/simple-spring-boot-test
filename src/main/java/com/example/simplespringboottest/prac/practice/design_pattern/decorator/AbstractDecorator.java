package com.example.simplespringboottest.prac.practice.design_pattern.decorator;

/**
 * @ ClassName: AbstractDecorator
 * @Author: legen
 * @Date: 2020/12/10
 */
public class AbstractDecorator implements Water{

    private Water water;

    public AbstractDecorator(Water water) {
        this.water = water;
    }

    @Override
    public void drink() {
        water.drink();
    }
}
