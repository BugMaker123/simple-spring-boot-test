package com.example.simplespringboottest.prac.practice.design_pattern.observer;

/**
 * @ ClassName: PlayerC
 * @Author: legen
 * @Date: 2020/12/10
 */
public class PlayerC extends Observer{

    public PlayerC(Subject subject) {
        this.subject = subject;
        subject.addPerson(this);
    }

    @Override
    void update() {
        System.out.println(this.getClass().getSimpleName()+"============"+  subject.getState());
    }
}
