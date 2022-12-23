package com.example.simplespringboottest.prac.first.base;

public class JoinTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new myThread());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }

}


class myThread implements Runnable {

    @Override
    public void run() {
        System.out.println("myThread run start......");
        try {
            Thread.sleep(5 * 1000); //等待5s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("myThread run end");
    }

}
