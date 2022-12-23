package com.example.simplespringboottest.prac.net.mult.base;

import java.util.concurrent.locks.LockSupport;

/**
 * 使用LockSupport
 */
public class LockSupportTest2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                LockSupport.park();
                System.out.println(sum);
            }
        });
        thread.start();
        LockSupport.unpark(thread);
    }

}
