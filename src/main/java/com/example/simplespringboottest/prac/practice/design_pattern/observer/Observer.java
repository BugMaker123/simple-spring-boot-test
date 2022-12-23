package com.example.simplespringboottest.prac.practice.design_pattern.observer;


/** 依赖抽象而非具体,
 *  subject是主体(被观察者,一旦状态发生变化就要通知到三个玩家),
 *  三个玩家是实际的观察者
 * @ ClassName: Observer
 * @Author: legen
 * @Date: 2020/12/10
 */
public abstract class Observer  {

    protected Subject subject;

    abstract void update();
}
