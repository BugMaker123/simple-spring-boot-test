package com.example.simplespringboottest.prac.practice.multi.base;

import java.util.concurrent.*;

/**
 * @ ClassName: T1_CreateThread
 * @Author: legen
 * @Date: 2021/3/8
 */
public class T01_CreateThread {
    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("this is a simple method");

        }
    }

    private static class MyCallable implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("this is a simple method for call");
            return this;
        }
    }
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("this is a simple method for run");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 启动线程的五种方式
        new MyThread().start();
        new Thread(new MyRunnable()).start();
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start();
        // 使用future
        new Thread(new FutureTask<String>(new MyCallable())).start();
        // 使用线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        Future submit = threadPool.submit(new MyCallable());
        System.out.println(submit.get());
    }
}
