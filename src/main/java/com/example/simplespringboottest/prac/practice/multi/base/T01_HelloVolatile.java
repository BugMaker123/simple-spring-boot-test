package com.example.simplespringboottest.prac.practice.multi.base;

import java.util.concurrent.TimeUnit;

public class T01_HelloVolatile {
   // /*volatile*/ boolean running = true; //对比一下有无volatile的情况下，整个程序运行 结果的区别
   volatile boolean running = true; //对比一下有无volatile的情况下，整个程序运行 结果的区别
    void m() {
        System.out.println("m start");
        while(running) {
        }
        System.out.println("m end!");
    }
    public static void main(String[] args) {
/*        T01_HelloVolatile t = new T01_HelloVolatile();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;*/
        T01_HelloVolatile t = new T01_HelloVolatile();
        new Thread(new Runnable() {
            @Override
            public void run() {
               t.m();
            }
        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
    }
}
