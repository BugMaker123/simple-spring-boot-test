package com.example.simplespringboottest.prac.practice.design_pattern.builder;

/**
 * @ ClassName: Builder
 * @Author: legen
 * @Date: 2020/12/15
 */
public abstract class Builder {
    abstract void buildA();
    abstract void buildB();
    abstract void buildC();
    abstract SuperMarket getResult();
}
