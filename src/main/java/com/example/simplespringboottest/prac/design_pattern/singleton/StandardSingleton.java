package com.example.simplespringboottest.prac.design_pattern.singleton;

public class StandardSingleton {
    private static volatile StandardSingleton instance = null;

    private StandardSingleton() {
    }

    public static StandardSingleton getInstance() {
        if (instance == null) {
            synchronized (StandardSingleton.class) {
                if (instance == null) {
                    instance = new StandardSingleton();
                }
            }
        }
        return instance;
    }
}
