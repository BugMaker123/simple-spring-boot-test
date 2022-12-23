package com.example.simplespringboottest.prac.first.mult;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultTicket {
    public static int ticketNum = 100;
    public static int ticketNum1 = 100;
    public static int ticketNum2 = 100;
    public static String key = "Key";

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                //synchronized (key){
                ticketNum--;
                System.out.println(Thread.currentThread().getName() + "===" + ticketNum);
                //}
            }, "m" + i).start();
        }
        System.out.println("==================================");
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                synchronized (key) {
                    ticketNum1--;
                    //System.out.println(Thread.currentThread().getState());
                    System.out.println(Thread.currentThread().getName() + "===" + ticketNum1);
                }
            }, "t" + i).start();
        }
        System.out.println("==================================");
        for (int i = 0; i < 100; i++) {
            Lock lock = new ReentrantLock(true);
            new Thread(() -> {
                lock.lock();
                ticketNum2--;
                System.out.println(Thread.currentThread().getName() + "===" + ticketNum2);
                //System.out.println(Thread.currentThread().getState());
                lock.unlock();

            }, "L" + i).start();
        }
    }
}
