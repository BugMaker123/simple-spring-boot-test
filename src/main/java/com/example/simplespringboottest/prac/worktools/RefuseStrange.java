package com.example.simplespringboottest.prac.worktools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ ClassName: RefuseStrange
 * @Author: legen
 * @Date: 2021/5/13
 */
public class RefuseStrange {
    private static AtomicInteger count = new AtomicInteger(0);
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    count.incrementAndGet();
                    num++;
                    System.out.println(Thread.currentThread().getName() + ":count" + "=" + count + ",num=" + num);
                }
            });
           // System.out.println(threadLocal.get());
        }

    }
}
