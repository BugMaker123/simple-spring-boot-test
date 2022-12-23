package com.example.simplespringboottest.prac.first.mult.basemult;

import java.util.concurrent.CyclicBarrier;

/**
 *  CyclicBarrier的基础使用
 *  CyclicBarrier
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        c.await();
                    } catch (Exception e) {
                    }
                    System.out.println(1);
                }
            }).start();
        }
        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }
}

