package com.example.simplespringboottest.prac.first.mult;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class SimpleThreadTest {
    public static int count =0;
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println(Thread.currentThread().getName()+"====当前count为"+count);
            }
        },"线程2").start();

        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                count++;
                System.out.println("当前线程为"+Thread.currentThread().getName()+",====当前count为"+count);
            }
        });
    }
}
