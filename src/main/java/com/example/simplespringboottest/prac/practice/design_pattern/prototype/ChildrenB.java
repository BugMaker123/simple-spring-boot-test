package com.example.simplespringboottest.prac.practice.design_pattern.prototype;

/**
 * @ ClassName: ChildrenA
 * @Author: legen
 * @Date: 2020/12/16
 */
public class ChildrenB extends Parent{
    public ChildrenB() {
        name="child B";
        age="21";
        profession="teacher";
    }

    @Override
    void eat() {
        System.out.println("eat very slowly");
    }
}
