package com.example.simplespringboottest.prac.first.mult.lockservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
@Slf4j
public class RepeatableLock {
    public static Integer count = 0;
    static  ReentrantLock lock = new ReentrantLock(false);
    public static void main(String[] args) {
        new Thread(()->{
            RepeatableLock repeatableLock = new RepeatableLock();
            repeatableLock.retree1();
        }).start();
    }

    public void retree1(){
        String threadName = Thread.currentThread().getName();
        lock.lock();
        System.out.println("第一次加锁:"+threadName);
       /* lock.lock();
        System.out.println("第二次加锁:"+threadName);
        System.out.println(count);
        lock.unlock();
        System.out.println("第一次解锁:"+threadName);*/
        retree2();
        log.info("同一个线程对一个对象加了一次锁以后，还可以继续加锁");
        lock.unlock();
        System.out.println("第二次解锁:"+threadName);
    }
    public void retree2(){
        lock.lock();
        // xxxx
        lock.unlock();
    }
}
