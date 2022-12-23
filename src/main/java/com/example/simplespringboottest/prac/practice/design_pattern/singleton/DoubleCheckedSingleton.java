package com.example.simplespringboottest.prac.practice.design_pattern.singleton;

/**
 * @ ClassName: DoubleCheckedSingleton
 * @Author: legen
 * @Date: 2020/12/10
 */
public class DoubleCheckedSingleton {
    private static DoubleCheckedSingleton instance=null;
    private DoubleCheckedSingleton(){}

    public DoubleCheckedSingleton getInstance(){
        if (instance==null){
            synchronized (this){
                if (instance==null){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
