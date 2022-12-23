package com.example.simplespringboottest.prac.net.socket;

import java.io.IOException;
import java.util.concurrent.*;

public class Test {
    /**
     * 直接创建对象，依次运行server，client是不可行的，因为server的accept()方法是阻塞的，会一直等待client的连接
     * 所以先异步执行client，在其开启后阻塞线程2s，再执行server
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String str = "hello communication";
        CompletableFuture.runAsync(() -> {
            try {
                new SocketClient().sentMsg(str);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        new SocketServer().receiveMsg();

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        newCachedThreadPool.execute(futureTask);

        newCachedThreadPool.shutdown();
        Future<String> submit = newCachedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() {
                return "sss";
            }
        });

        new ConcurrentHashMap<String,String>();

        new CopyOnWriteArrayList<String>();

    }
}
