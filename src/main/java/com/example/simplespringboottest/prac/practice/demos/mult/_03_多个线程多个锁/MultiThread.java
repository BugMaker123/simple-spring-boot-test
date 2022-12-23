package com.example.simplespringboottest.prac.practice.demos.mult._03_多个线程多个锁;

/*
 * 在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁、独占锁
 * 否则是对象锁
 */
@SuppressWarnings("static-access")
public class MultiThread {

    public static int number_static = 0;
    public int number = 0;

    /* static   from:txd2016_5_11 180918*/
    public static synchronized void printNumber_static(String tag) {
        System.err.println("这里是:printNumber_static " + tag);
        if ("a".equals(tag)) {
            number_static = 100;
            System.out.println("tag : a,set number over");
        } else {
            number_static = 200;
            System.out.println("tag is not a:set number over");
        }
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结果:" + tag + ", number:" + number_static);
    }

    /*no static  from:txd2016_5_11 180918*/
    public synchronized void printNumber_void(String tag) {
        System.err.println("这里是:printNumber_void " + tag);
        if ("a".equals(tag)) {
            number = 100;
            System.out.println("tag : a,set number over");
        } else {
            number = 200;
            System.out.println("tag is not a:set number over");
        }
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结果:" + tag + ", number:" + number);
    }

    /* 观察run方法输出顺序 */
    public static void main(String[] args) {
        //两个不同的对象
        final MultiThread thread_static1 = new MultiThread();
        final MultiThread thread_static2 = new MultiThread();

        //两个不同的对象访问static锁
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread_static1.printNumber_static("a");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread_static2.printNumber_static("b");
            }
        });

        //两个不同的对象
        final MultiThread thread_void1 = new MultiThread();
        final MultiThread thread_void2 = new MultiThread();
        //两个不同的对象访问static锁
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread_void1.printNumber_void("a");
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread_void2.printNumber_void("b");
            }
        });

        System.out.println("两个不同的对象访问static锁");
        t1.start();
        t2.start();
        System.err.println("执行结果:t1与t2按顺序执行,即先到者先将类锁住了，"
                + "后来者只有等前面的执行结束之后才能执行");

        System.out.println("两个不同的对象访问非static锁");
        t3.start();
        t4.start();
        System.err.println("执行结果:t3与t4并发执行，之间互不影响，所操作的都是自己的对象内内容");
    }

}
