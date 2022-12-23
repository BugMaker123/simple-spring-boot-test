package com.example.simplespringboottest.prac.first.mult.volatileTest;

import static java.lang.Thread.interrupted;

public class VolatilePrinciple2 {
    public static int  num = 100;

    public static void main(String[] args) throws InterruptedException {

        Thread t2 = new Thread(()->{
            try {
                num--;
                System.out.println(Thread.currentThread().getName()+"==="+num);
                interrupted();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t2.start();
        //sleep(2300);
        t2.interrupt();
        if(t2.isInterrupted()){
            System.out.println(true);
        }

       /* new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"==="+num);
        },"t1").start();*/

    }
}
