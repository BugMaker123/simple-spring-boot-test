package com.example.simplespringboottest.prac.practice.design_pattern.singleton;

/**
 * @ ClassName: SafetyLazySingleton
 * @Author: legen
 * @Date: 2020/12/10
 */
public class SafetyLazySingleton {
    private static SafetyLazySingleton instance = null;
    private SafetyLazySingleton(){

    }
    public synchronized SafetyLazySingleton getInstance(){
        if (instance==null){
            instance=new SafetyLazySingleton();
        }
        return instance;
    }
}
