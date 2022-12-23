package com.example.simplespringboottest.prac.first.mult.volatileTest;

import static java.lang.Thread.sleep;

/**
 * 使用数字进行观察可见性
 */
public class VolatileTestPro2 {
    public static volatile Integer num = 101;

    void getNum(){
        while (num==101){

        }
        System.out.println(Thread.currentThread().getName()+"==="+num);
    }
    public static void main(String[] args) {
        VolatileTestPro2 pro = new VolatileTestPro2();
        new Thread(pro::getNum,"t1").start();
        new Thread(pro::getNum,"t2").start();
        new Thread(()->{
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num =100;
            pro.getNum();
        },"t3").start();
    }
}
