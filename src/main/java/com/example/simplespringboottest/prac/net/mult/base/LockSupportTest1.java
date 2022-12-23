package com.example.simplespringboottest.prac.net.mult.base;

import java.util.concurrent.locks.LockSupport;

/**
 * 原始写法
 */
public class LockSupportTest1 {
    public static void main(String[] args) throws InterruptedException {
        final Object obj = new Object();
        Thread A = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            try {
               synchronized (obj) {
                   obj.wait();
               }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        Thread.sleep(1000);
       synchronized (obj) {
           obj.notify();
       }
        System.out.println("main thread over");
    }

}
