package com.example.simplespringboottest.prac.practice.design_pattern.observer;

/**
 * @ ClassName: PlayerB
 * @Author: legen
 * @Date: 2020/12/10
 */
public class PlayerB extends Observer{
    public PlayerB(Subject subject) {
        this.subject = subject;
        subject.addPerson(this);
    }

    @Override
    void update() {
        System.out.println(this.getClass().getSimpleName()+"============"+  subject.getState());
    }
}
