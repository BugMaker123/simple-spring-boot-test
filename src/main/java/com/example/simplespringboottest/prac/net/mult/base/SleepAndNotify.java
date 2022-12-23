package com.example.simplespringboottest.prac.net.mult.base;

public class SleepAndNotify {
    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        thread.start();
        thread.getYield();
        System.out.println(thread.getState());
        thread.getSleep();


    }

}
class MyThread2 extends Thread{
    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " start");
    }

    public void getSleep() {
        synchronized (this) {
            try {
                sleep(2000);
                System.out.println("sleep===" + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getYield() {
        synchronized (this) {
            yield();
            System.out.println("yield===" + Thread.currentThread().getState());
        }
    }
}