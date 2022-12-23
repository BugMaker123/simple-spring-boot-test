package com.example.simplespringboottest.prac.net.mult;

/**
 * 使用jps定位到进程号，
 * 然后使用jstack -l 进程号查看线程堆栈信息
 */
public class DieLockTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (String.class) {
                    System.out.println("A");
                    synchronized (Integer.class) {
                        System.out.println("B");
                    }
                }
            }
        });
       Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Integer.class) {
                    System.out.println("C");
                    synchronized (String.class) {
                        System.out.println("D");
                    }
                }
            }
        });
       t1.start();
       t2.start();
    }
}
