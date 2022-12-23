package com.example.simplespringboottest.prac.first.designPattern.factory;

import lombok.Data;

@Data
public class World<T>{

    private String name;

    private Integer rank;

    public LiveFactory createLiveFactory(){
        return LiveFactory.getInstance();
    }

    public NonLiveFactory createNonLiveFactory(){
        return NonLiveFactory.getInstance();
    }
}
