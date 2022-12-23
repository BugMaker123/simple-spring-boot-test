package com.example.simplespringboottest.prac.first.mult.lockservice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockBase {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();

        HashSet<Thread> hashSet = new HashSet<>();
        LinkedList<Thread> linkedList = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock(false);
        lock.lock();
        while (true){
            // 获取到锁 就进去,但这时候线程空转,一直在for循环中
            if (lock.isLocked()) {
                //
                break;
            }
            // 交出CPU的使用权,如果线程过多会导致系统资源浪费
            //Thread.yield();
            // 使用线程睡眠,由于没办法确定当前线程要执行多久,所以不可以
            //Thread.sleep(11);
            // 直接阻塞,会无法唤醒,所以将线程放入LinkedList对象中
            //LockSupport.park();
            hashSet.add(t1);
            linkedList.add(t1);
            // 阻塞
            LockSupport.park();
        }
        // todo 业务代码

        LockSupport.unpark(t1);
        lock.unlock(); //提供线程唤醒的方法 LockSupport.unPark(t1);
    }
}
