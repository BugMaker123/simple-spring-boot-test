package com.example.simplespringboottest.prac.first.designPattern.factory;

public class God {

    public God() {
        System.out.println("We have a God");
    }

    public WorldFactory createWorldFactory() {
        WorldFactory worldFactory = WorldFactory.getInstance();
        System.out.printf("God create a WorldFactory:%s\n", worldFactory);
        return worldFactory;
    }
}
