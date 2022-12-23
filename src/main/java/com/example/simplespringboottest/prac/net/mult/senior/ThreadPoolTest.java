package com.example.simplespringboottest.prac.net.mult.senior;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ThreadPoolTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.单线程
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        singleExecutorService.shutdown();
        // 2.自动扩容线程池
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.shutdown();
        // 3.定时任务线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.shutdown();
        // 4.定长
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                sleep(2000);
                return 1;
            }
        });
        System.out.println(future.get());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("execute");
            }
        });

        Future<Integer> f3 = executorService.submit(new MyThread());
        System.out.println(f3.get());


        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "FutureTask";
            }
        });
        // FutureTask<String> task = new FutureTask<>(new MyThread());
        Future<?> f4 = executorService.submit(task);
        System.out.println(f4.get());
        System.out.println(task.get());
        executorService.shutdown();
    }

    static class MyThread implements Callable<Integer> {
        @Override
        public Integer call() {
            System.out.println("hello");
            return 0;
        }
    }
}
