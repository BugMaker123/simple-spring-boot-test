package com.example.simplespringboottest.prac.practice.multi.base;

/**
 * @ ClassName: T06_Async_Sync
 * @Author: legen
 * @Date: 2021/3/15
 */
public class T06_Async_Sync {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }
    public void m2() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        T06_Async_Sync t06 = new T06_Async_Sync();
        new Thread(t06::m1).start();
        new Thread(t06::m2).start();
    }
}
