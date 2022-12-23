package com.example.simplespringboottest.prac.practice.design_pattern.observer;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/12/10
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject("2");
        new PlayerA(subject);
        new PlayerB(subject);
        new PlayerC(subject);
        subject.setState("4");
    }
}
