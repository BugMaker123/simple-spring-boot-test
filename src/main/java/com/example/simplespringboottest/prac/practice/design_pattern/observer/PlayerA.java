package com.example.simplespringboottest.prac.practice.design_pattern.observer;

/**
 * @ ClassName: PlayerA
 * @Author: legen
 * @Date: 2020/12/10
 */
public class PlayerA extends Observer{
    public PlayerA(Subject subject) {
        this.subject = subject;
        subject.addPerson(this);
    }

    @Override
    void update() {
        System.out.println(this.getClass().getSimpleName()+"============"+  subject.getState());
    }
}
