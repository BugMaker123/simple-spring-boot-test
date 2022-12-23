package com.example.simplespringboottest.prac.practice.demos.mult._03_锁讲解;


import org.junit.jupiter.api.Test;

public class MyThread01Test {
    MyThread01 myThread = new MyThread01();

    @Test
    public void testMethod() {
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
