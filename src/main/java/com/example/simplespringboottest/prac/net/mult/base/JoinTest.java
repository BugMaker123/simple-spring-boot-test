package com.example.simplespringboottest.prac.net.mult.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JoinTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("t1");
        MyThread t2 = new MyThread();
        t2.setName("t2");
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static class MyThread extends Thread{
        private static Lock lock = new ReentrantLock();
        @Override
        public  void run() {
            try {
                sleep(2000);
                System.out.println(Thread.currentThread().getName()+"执行完成");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
