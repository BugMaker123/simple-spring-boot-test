package com.example.simplespringboottest.prac.design_pattern.templatePattern;

public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    void initialize(int i ){
        System.out.println("Football Game Initialized! Start playing.");
    }

    public static void main(String[] args) {
        Game game = new Football();
        game.play();
    }
}

