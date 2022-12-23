package com.example.simplespringboottest.prac.first.mult.volatileTest;


import static jodd.util.ThreadUtil.sleep;

/**
 * 最直观的是使用布尔类型去看
 */
public class VolatileTestPro {

    public static volatile boolean flag = true;

    void method(){
        while (flag){

        }
        System.out.println(Thread.currentThread().getName()+"-----"+flag);
    }

    public static void main(String[] args) {

        VolatileTestPro pro = new VolatileTestPro();


        System.out.println("==============");
        new Thread(()->{
            sleep(5000);
            // t1,t2,t3 线程进入阻塞状态，当主线程修改数据时，使用volatile时，t1，t2,t3可以直接获取到值，否则获取不到
            flag=!flag;
        },"t2").start();
        new Thread(pro::method,"t3").start();
        new Thread(pro::method,"t1").start();
      /*  sleep(5000);
        // t1,t2,t3 线程进入阻塞状态，当主线程修改数据时，使用volatile时，t1，t2,t3可以直接获取到值，否则获取不到
        flag=!flag;*/
    }
}
