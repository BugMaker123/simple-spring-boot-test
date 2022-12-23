package com.example.simplespringboottest.prac.math.vmTest;

/**
 * 大对象直接进入老年代
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
 */
public class GcTest1 {
    public static void main(String[] args) {
        byte[] bytes = new byte[1024 * 1024 * 3];
    }
}
