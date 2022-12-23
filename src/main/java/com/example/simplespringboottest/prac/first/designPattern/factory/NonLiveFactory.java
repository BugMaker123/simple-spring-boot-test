package com.example.simplespringboottest.prac.first.designPattern.factory;

public class NonLiveFactory {
    private static volatile NonLiveFactory instance = null;

    private NonLiveFactory() {
        System.out.println("get a NonLiveFactory");
    }

    public static NonLiveFactory getInstance() {
        if(instance == null) {
            synchronized (NonLiveFactory.class) {
                if (instance == null) {
                    instance = new NonLiveFactory();
                }
            }
        }
        return instance;
    }

    public void createNonLive(String nonLive) {
        System.out.printf("create no");
    }
}
