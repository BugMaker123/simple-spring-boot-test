package com.example.simplespringboottest.prac.practice.demos.simpleep;

/**
 * @ ClassName: Test
 * @Author: legen
 * @Date: 2020/11/11
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                   synchronized (Ticket.class){
                       System.out.println(Thread.currentThread().getName()+"==="+Thread.currentThread().getId()+"===="+Ticket.count);
                       Ticket.count--;
                   }
                }
            }).start();
        }
    }
}
