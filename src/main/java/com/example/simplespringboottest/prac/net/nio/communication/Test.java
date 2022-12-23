package com.example.simplespringboottest.prac.net.nio.communication;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->{
            new NioServer().createNioServer();
        });
        sleep(5000);
        CompletableFuture.runAsync(() -> {
            try {
                sleep(1000);
                new NioClient().createNioClient();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

