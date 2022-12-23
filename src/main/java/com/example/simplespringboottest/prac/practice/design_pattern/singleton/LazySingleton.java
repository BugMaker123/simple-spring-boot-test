package com.example.simplespringboottest.prac.practice.design_pattern.singleton;

/**
 * @ ClassName: LazySingleton
 * @Author: legen
 * @Date: 2020/12/10
 */
public class LazySingleton {

    private static LazySingleton instance = null;
    // 私有构造方法
    private LazySingleton(){

    }
    public static LazySingleton getInstance(){
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
