package com.example.simplespringboottest.prac.first.mult.volatileTest;

import static java.lang.Thread.sleep;

public class VolatilePrinciple {

    public static int  num = 100;

    public static void main(String[] args) {

        Thread t2 = new Thread(()->{
            try {
                sleep(2000);
                num--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"==="+num);
        },"t1").start();

    }
}
