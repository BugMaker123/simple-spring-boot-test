package com.example.simplespringboottest.prac.practice.demos.mult._03_锁讲解;

public class MyThread01 extends Thread {
    private int count = 3;

    //synchronized 加锁
    //synchronized
    @Override
	@SuppressWarnings("static-access")
    public synchronized void run() {
        count--;
        float result = 100 / count;
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(this.currentThread().getName() + " count = " + count + "  \t result = " + result);
    }

    public static void main(String[] args) {
        MyThread01 myThread = new MyThread01();
        Thread t1 = new Thread(myThread, "t1");
        Thread t2 = new Thread(myThread, "t2");
        Thread t3 = new Thread(myThread, "t3");
        Thread t4 = new Thread(myThread, "t4");
        Thread t5 = new Thread(myThread, "t5");
        Thread[] threads = {t1, t2, t3, t4, t5};
        for (Thread t : threads) {
            t.start();
        }
    }
}
