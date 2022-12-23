package com.example.simplespringboottest.prac.practice.multi.base;

/**
 * @ ClassName: T04_DiedLock
 * @Author: legen
 * @Date: 2021/3/15
 */
public class T04_Died_Lock{
    private  Object lock1 = new Object();
    private  Object lock2 = new Object();

    public  void method1() throws InterruptedException {
        synchronized(lock1){
            System.out.println(Thread.currentThread().getName() + "获取到lock1,请求获取lock2....");
            Thread.sleep(1000);
            synchronized (lock2){
                System.out.println("获取到lock2....");
            }
        }
    }
    public  void method2() throws InterruptedException {
        synchronized(lock2){
            System.out.println(Thread.currentThread().getName() + "获取到lock2,请求获取lock1....");
            Thread.sleep(1000);
            synchronized (lock1){
                System.out.println("获取到lock1....");
            }
        }
    }

    public static void main(String[] args) {
        T04_Died_Lock deadLock = new T04_Died_Lock();

        new Thread(()-> {
            try {
                deadLock.method1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                deadLock.method2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

