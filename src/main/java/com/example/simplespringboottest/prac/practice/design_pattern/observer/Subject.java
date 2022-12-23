package com.example.simplespringboottest.prac.practice.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName: Subject
 * @Author: legen
 * @Date: 2020/12/10
 */
public class Subject {
    private String state;
    List<Observer> observerList = new ArrayList<>();

    public Subject() {
    }

    public Subject(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        noticeUpdate(observerList);
    }

    void addPerson(Observer person) {
        observerList.add(person);
    }

    void removePerson(Observer person) {
        observerList.remove(person);
    }

    void noticeUpdate(List<Observer> observerList) {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
