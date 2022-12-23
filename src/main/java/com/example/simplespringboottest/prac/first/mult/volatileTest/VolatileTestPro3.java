package com.example.simplespringboottest.prac.first.mult.volatileTest;

import static jodd.util.ThreadUtil.sleep;

/**
 * 进一步证实主线程改了值,子线程也是可以获取到的
 */
public class VolatileTestPro3 {

    public static volatile boolean flag = true;

    void method(){
        while (flag){

        }
        System.out.println(Thread.currentThread().getName()+"-----"+flag);
    }

    public static void main(String[] args) {

        VolatileTestPro3 pro = new VolatileTestPro3();


        System.out.println("==============");
        new Thread(pro::method,"t2").start();
        new Thread(pro::method,"t3").start();
        new Thread(pro::method,"t1").start();
        sleep(5000);
        flag=!flag;
    }
}
