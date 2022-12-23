package com.example.simplespringboottest.prac.math.vmTest;

/**
 * g1垃圾收集器测试
 * -XX:+UseG1GC -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 */
public class G1Test {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024 * 3];
        byte[] bytes1 = new byte[1024 * 1024 * 3];
/*        byte[] bytes2 = new byte[1024 * 1024 * 3];
        byte[] bytes3 = new byte[1024 * 1024 * 3];*/
    }
}
