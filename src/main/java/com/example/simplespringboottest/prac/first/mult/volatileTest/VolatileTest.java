package com.example.simplespringboottest.prac.first.mult.volatileTest;

import static java.lang.Thread.sleep;

public class VolatileTest {
    //public static volatile boolean flag =true;
    public static boolean flag =true;

    public static void main(String[] args) {
        System.out.println("start");
        new Thread(()->{
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (flag){

            }
            System.out.println(flag);
            System.out.println("end");
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
        }).start();
    }
}
