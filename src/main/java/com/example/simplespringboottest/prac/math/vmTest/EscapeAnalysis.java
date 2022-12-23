package com.example.simplespringboottest.prac.math.vmTest;

import com.example.simplespringboottest.entity.User;

/**
 * 逃逸分析与标量替换
 *  开启逃逸分析 -XX:+DoEscapeAnalysis
 *  关闭逃逸分析 -XX:-DoEscapeAnalysis
 *  JDK7后的版本默认开启逃逸分析
 *
 *
 *  标量替换：如果栈上连续内存不足，就将对象打散成为基本数据类型，然后分散到栈上，
 *  开启标量替换 -XX:+EliminateAllocations
 *  关闭标量替换 -XX:-EliminateAllocations
 *  JDK7后的版本默认开启标量替换
 *
 */
public class EscapeAnalysis {

    /**
     * 无返回值，user对象在此方法内就结束了，此时可以通过标量替换对象会在栈上分配
     */
    public void test1(){
        User user = new User();
        user.setId(0L);
        user.setName("12");
        user.setPassword("33");
        user.setEmail("44");
        // insert(user);
    }

    /**
     * 此时有返回值，User对象被别的地方引用到，这时候User逃逸出了方法，会在堆上分配
     * @return
     */
    public User test2(){
        User user = new User();
        user.setId(0L);
        user.setName("12");
        user.setPassword("33");
        user.setEmail("44");
        // insert(user);
        return user;
    }
}
