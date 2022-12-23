package com.example.simplespringboottest.prac.first.mult;

public class SyncTest {
    public static volatile int num = 100;

    synchronized void getState() {
        num --;
        System.out.println(Thread.currentThread().getName()+"==="+num);
    }

    public static void main(String[] args) {
        SyncTest sync = new SyncTest();
        for (int i = 0; i < 10; i++) {
            new Thread(sync::getState).start();
        }
    }
}
