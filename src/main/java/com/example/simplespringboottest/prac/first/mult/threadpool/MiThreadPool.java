package com.example.simplespringboottest.prac.first.mult.threadpool;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class MiThreadPool  {


    public static MiThreadPool createThreadPool(ThreadFactory threadFactory, Long time, TimeUnit timeType,
                                        int maxThread, int coreThreadSize, RejectedExecutionHandler handler, BlockingQueue<Thread>queue){
        return new MiThreadPool();
    }

    void execute(Thread thread){

    }
    /*<T> Future<T> submit(Callable<T> task){
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task);
        execute(ftask);
        return ftask;
        return (io.netty.util.concurrent.Future)super.submit(task);
    }*/
    // 线程的状态:
    // 线程池的状态: stop,terminal,shutdown,running,
}
