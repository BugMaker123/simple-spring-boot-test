package com.example.simplespringboottest.prac.practice.design_pattern.builder.demo;


/**
 * @ ClassName: Builder
 * @Author: legen
 * @Date: 2020/12/15
 */
public abstract class AbstractBuilder {
    abstract void buildGood(Good good);
    abstract Market getMarket();
}
