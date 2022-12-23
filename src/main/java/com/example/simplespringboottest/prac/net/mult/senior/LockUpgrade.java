package com.example.simplespringboottest.prac.net.mult.senior;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * 查看synchronized锁升级
 */
public class LockUpgrade {
   /**
    * 无锁状态 -001
    */
   @Test
   public void nonLock() {
       Object o = new Object();
       System.out.println(ClassLayout.parseInstance(o).toPrintable());
   }

    /**
     * 偏向锁状态 -101
     */
   @Test
    public void lock() {
       Object o = new Object();
       synchronized (o) {
           System.out.println(ClassLayout.parseInstance(o).toPrintable());
       }
   }

    /**
    * 轻量级锁状态 -100
    */
    @Test
    public void lightLock() {
        Object o = new Object();
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
    /**
     * 重量级锁状态 -100
     */
    @Test
    public void heavyLock() {
        Object o = new Object();
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
