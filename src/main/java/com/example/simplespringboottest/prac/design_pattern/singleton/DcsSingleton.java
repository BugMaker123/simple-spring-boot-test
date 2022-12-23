package com.example.simplespringboottest.prac.design_pattern.singleton;

public class DcsSingleton {
    private static DcsSingleton instance = null;

    private DcsSingleton() {
    }

    public static DcsSingleton getInstance() {
        if (instance == null) {
            synchronized (DcsSingleton.class) {
                if (instance == null) {
                    instance = new DcsSingleton();
                }
            }
        }
        return instance;
    }

}
