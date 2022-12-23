package com.example.simplespringboottest.prac.first.mult.lockservice;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("1111111111111111");
            LockSupport.park();
            System.out.println("22222222222222222222");

        },"t");
        t.start();
        LockSupport.unpark(t);

        AbstractQueuedSynchronizer queuedSynchronizer = new AbstractQueuedSynchronizer(){
        };

    }
}
