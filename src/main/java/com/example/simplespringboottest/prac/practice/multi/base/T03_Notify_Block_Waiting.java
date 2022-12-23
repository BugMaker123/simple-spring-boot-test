package com.example.simplespringboottest.prac.practice.multi.base;


import static java.lang.Thread.sleep;

/**
 * notify与wait都必须在synchronized内执行
 * @ ClassName: T04_notify_block_waiting
 * @Author: legen
 * @Date: 2021/3/11
 */
public class T03_Notify_Block_Waiting {
    private static Integer num =10;
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread B==="+i);
            }
        });

        Thread t1 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                if (i%10==0){
                    try {
                      synchronized (num){
                          num.wait(200);
                          System.out.println(i);
                      }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread A==="+i);
            }
        });
        System.out.println(t1.getState());

        t1.start();
        System.out.println(t1.getState());
        sleep(2000);
        System.out.println(t1.getState());
        synchronized (num){
            num.notify();
        }
        System.out.println(t1.getState());
        t2.start();
        System.out.println(t2.getState());

    }
}
