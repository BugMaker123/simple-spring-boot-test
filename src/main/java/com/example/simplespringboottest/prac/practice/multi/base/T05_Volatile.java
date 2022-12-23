package com.example.simplespringboottest.prac.practice.multi.base;

import lombok.SneakyThrows;

/**
 * @ ClassName: T05_Volatile
 * @Author: legen
 * @Date: 2021/3/15
 */
public class T05_Volatile implements Runnable {
    private volatile static Integer num =0;

    @SneakyThrows
    @Override
    public void run() {
        num++;
        if (Thread.currentThread().getName().equals("t1")){
            //sleep(5000);
            System.out.println(Thread.currentThread().getName()+"=="+num);
        }else{
            //sleep(2000);
            System.out.println(Thread.currentThread().getName()+"=="+num);
        }
    }

    public static void main(String[] args) {
        T05_Volatile aVolatile = new T05_Volatile();
        new Thread(aVolatile,"t1").start();
        new Thread(aVolatile,"t2").start();
        /*for (int i = 0; i < 100; i++) {
            new Thread(aVolatile).start();
        }*/
    }
}
