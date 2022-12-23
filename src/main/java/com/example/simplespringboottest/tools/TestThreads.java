package com.example.simplespringboottest.tools;

public class TestThreads {

    private static int count = 0;
    private static String key = "abc";

    public static void main(String[] args) {
        System.out.println("======");

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                   synchronized (key){
                       count++;
                       System.out.println(Thread.currentThread().getName()+"thread run"+count);
                   }
                }
            },"t"+i).start();
        }
        System.out.println("end");
    }
}
