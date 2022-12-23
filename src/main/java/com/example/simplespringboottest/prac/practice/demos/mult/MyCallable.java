package com.example.simplespringboottest.prac.practice.demos.mult;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("创建线程的第三种方式");
        return "create thread3 success";
    }
}
