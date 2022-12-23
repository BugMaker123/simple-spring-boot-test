package com.example.simplespringboottest.prac.practice.design_pattern.prototype;

/**
 * @ ClassName: ChildrenA
 * @Author: legen
 * @Date: 2020/12/16
 */
public class ChildrenC extends Parent{
    public ChildrenC() {
        name="child C";
        age="22";
        profession="police";
    }

    @Override
    void eat() {
        System.out.println("eat less time");
    }
}
