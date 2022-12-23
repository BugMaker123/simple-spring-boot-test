package com.example.simplespringboottest.prac.net.mult.base;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    int res = num.incrementAndGet();
                    System.out.println(Thread.currentThread().getName()+"===="+res);
                    lock.unlock();
                }
            },"t"+i).start();
        }
    }
}
