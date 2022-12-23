package com.example.simplespringboottest.prac.practice.design_pattern.decorator;

/**
 * @ ClassName: RealDecorator
 * @Author: legen
 * @Date: 2020/12/10
 */
public class RealDecorator extends AbstractDecorator{
    public RealDecorator(Water water) {
        super(water);
    }

    @Override
    public void drink() {
        super.drink();
        pull();
    }

    void pull(){
        System.out.println("喝不完就倒掉");
    }
}
