package com.example.simplespringboottest.prac.design_pattern.templatePattern;

public abstract class Game implements Sport {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板 !! 必须是final
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
