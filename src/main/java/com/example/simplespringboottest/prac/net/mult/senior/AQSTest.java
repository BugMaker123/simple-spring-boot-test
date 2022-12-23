package com.example.simplespringboottest.prac.net.mult.senior;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {
    public static void main(String[] args) {

        AtomicInteger num = new AtomicInteger(0);

        ReentrantLock lock = new ReentrantLock(true);
        ReentrantLock lock2 = new ReentrantLock();
        System.out.println( lock.isFair());
        System.out.println( lock2.isFair());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock.lock();
                int res = num.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+"============"+res+"============"+lock.isLocked());
                lock.unlock();
            },"t"+i).start();
        }
    }


}
