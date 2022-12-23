package com.example.simplespringboottest.prac.net.mult.base;

/**
 * 使用volatile完成线程交替运行
 */
public class Test {
    public static class MyThread extends Thread{
        private volatile boolean flag = true;
        private int count = 0;

        @Override
        public void run() {
            while (count < 100) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + " " + count++);
                    flag = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
       /* t1.flag = true;
        t2.flag = false;*/
        t1.start();
        t2.start();
    }
}
