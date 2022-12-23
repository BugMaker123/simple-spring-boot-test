package com.example.simplespringboottest.prac.net.mult.base;

import static java.lang.Thread.sleep;

public class SimpleTest {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        a.start();
        a.sleep(1000);
        System.out.println("1s后唤醒");
        System.out.println(a.getState());
        a.yield();
        System.out.println(a.getState());
        System.out.println("已经唤醒");
        a.sleep(1000);

    }

}
