package com.example.simplespringboottest.prac.first.mult.lockservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁与非公平锁
 * 模拟多个线程
 */
@Slf4j
public class FairOrUnFairLock {
    private static CountDownLatch countDownLatch = new CountDownLatch(0);
    private static volatile Integer ticketNum = 100;

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {

                //FairOrUnFairLock fairOrUnFairLock = new FairOrUnFairLock();
                try {
                    countDownLatch.await();
                    lock.lock();
                    ticketNum--;
                    log.info("当前线程为{},获取到票,余下{}张票", Thread.currentThread().getName(), ticketNum);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }, "t" + i).start();
        }
    }

    public static void getTicket(Integer ticketNum) {
        ticketNum--;
        log.info("当前线程为{},获取到票,余下{}张票", Thread.currentThread().getName(), ticketNum);
    }
}
