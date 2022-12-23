package com.example.simplespringboottest.prac.first.mult.threadpool;

import java.util.concurrent.*;

public class SimpleThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.execute(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaaaaa");
            }
        }));

        Future<String> future = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("bbbbbbbbbb");
                return "ccccccc";
            }
        });
        System.out.println(future.get());
    }
}
