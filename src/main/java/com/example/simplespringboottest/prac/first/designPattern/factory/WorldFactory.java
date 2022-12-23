package com.example.simplespringboottest.prac.first.designPattern.factory;

public class WorldFactory <T>{
    private static volatile WorldFactory instance = null;
    private WorldFactory() {
        System.out.println("get a WorldFactory");
    }

    public static WorldFactory getInstance() {
        if(instance == null) {
            synchronized (WorldFactory.class) {
                if (instance == null) {
                    instance = new WorldFactory();
                }
            }
        }
        return instance;
    }

    public World createWorld(String worldName, Integer worldRank) {
        World world = new World();
        world.setName(worldName);
        world.setRank(worldRank);
        return world;
    }
}