package com.example.simplespringboottest.prac.first.designPattern.factory;

public class LiveFactory {
    private static volatile LiveFactory instance = null;
    private LiveFactory() {
        System.out.println("get a LiveFactory");
    }

    public static LiveFactory getInstance() {
        if(instance == null) {
            synchronized (LiveFactory.class) {
                if (instance == null) {
                    instance = new LiveFactory();
                }
            }
        }
        return instance;
    }

    public void createLive(String name) {
        System.out.printf("create a live:%s\n", name);
    }
}
