package com.example.simplespringboottest.prac.practice.design_pattern.prototype;

/**
 * @ ClassName: ChildrenA
 * @Author: legen
 * @Date: 2020/12/16
 */
public class ChildrenA extends Parent{
    public ChildrenA() {
        name="child A";
        age="28";
        profession="programmer";
    }

    @Override
    void eat() {
        System.out.println("eat very very fast");
    }
}
