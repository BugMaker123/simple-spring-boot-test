package com.example.simplespringboottest.prac.net.mult.base;

public class NotifyAndWait {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        thread.getWait();
        System.out.println(thread.getState());
        thread.getNotify();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " start");
    }

    public void getWait() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait===" + Thread.currentThread().getState());
        }
    }

    public void getNotify() {
        synchronized (this) {
            notify();
            System.out.println("notify===" + Thread.currentThread().getState());
        }
    }
}