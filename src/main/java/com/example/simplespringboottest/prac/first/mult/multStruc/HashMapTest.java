package com.example.simplespringboottest.prac.first.mult.multStruc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class HashMapTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);
        Queue<Thread> deque = new LinkedList();
        for (int i = 0; i < 20; i++) {

            Thread thread = new Thread(() -> {
                lock.lock();
                while (true) {
                    if (lock.isLocked()) {
                        break;
                    }
                    LockSupport.park();
                }
            }, "t" + i);
            thread.start();
            deque.add(thread);
            LockSupport.unpark(thread);
            lock.unlock();
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("1","1");

        System.out.println("===============");
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1","1");
    }
}
