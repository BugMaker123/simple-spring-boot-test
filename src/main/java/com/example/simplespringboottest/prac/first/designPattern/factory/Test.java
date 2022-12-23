package com.example.simplespringboottest.prac.first.designPattern.factory;

public class Test {
    public static void main(String[] args) {
        God god = new God();
        WorldFactory worldFactory = god.createWorldFactory();
        World world = worldFactory.createWorld("world1", 1);
        System.out.println(world.getName());
        System.out.println(world.getRank());

        LiveFactory liveFactory = world.createLiveFactory();
        NonLiveFactory nonLiveFactory = world.createNonLiveFactory();
        liveFactory.createLive("live");
        nonLiveFactory.createNonLive("nonLive");
    }
}
