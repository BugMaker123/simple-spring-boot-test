package com.example.simplespringboottest.prac.net.mult.senior;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class SeniorUse {
    public static void main(String[] args) {
        getCountDownLatchTest();
    }

    /**
     * CountDownLatch
     * 就是一个或者一组线程在开始执行操作之前，
     * 必须要等到其他线程执行完才可以。
     * 我们举一个例子来说明，在考试的时候，老师必须要等到所有人交了试卷才可以走。此时老师就相当于等待线程，而学生就好比是执行的线程。
     */
    final static CountDownLatch latch = new CountDownLatch(2);

    public static void getCountDownLatchTest() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                latch.countDown();
                System.out.println(Thread.currentThread().getName()+"已经就位");
            }
        },"player1");
        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"已经就位");
            }
        },"player2");
        t1.start();
        System.out.println(t1.getState());
        t2.start();
        System.out.println("等待两个线程执行完毕...");
    }

    /**
     * java中还有一个同步工具类叫做CyclicBarrier，
     * 他的作用和CountDownLatch类似。
     * 同样是等待其他线程都完成了，才可以进行下一步操作，我们再举一个例子，在打王者的时候，在开局前所有人都必须要加载到100%才可以进入。否则所有玩家都相互等待。
     */
    public static void getCyclicBarrierTest() {

    }
}
