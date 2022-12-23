package com.example.simplespringboottest.prac.practice.demos.mult;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程的第一种方式
        new MyThread().start();
        // 第二种
        new Thread(new MyRunnable()).start();

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        FutureTask<String>futureTask = new FutureTask<String>(new MyCallable());
        threadPool.submit(futureTask);
        System.out.println(futureTask.get());

    }
}
