package com.example.simplespringboottest.prac.first.mult.lockservice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单reetrantlock
 */
public class SimpleLock {
    private static CountDownLatch countDownLatch = new CountDownLatch(0);

    public static Integer val = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false); // false为非公平锁,true为公平锁
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    lock.lock();
                    for (int j = 0; j < 1000; j++) {
                        val++;
                    }
                    System.out.println(Thread.currentThread().getName() + "===" + val);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    lock.unlock();

                }
            }).start();
        }
    }
}
