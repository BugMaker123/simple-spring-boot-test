package com.example.simplespringboottest.prac.practice.design_pattern.singleton;

/**
 * @ ClassName: HungrySingleton
 * @Author: legen
 * @Date: 2020/12/10
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
