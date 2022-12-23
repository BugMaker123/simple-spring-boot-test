package com.example.simplespringboottest.prac.net.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class SimpleBufferTest {
    public static void main(String[] args) {
        // 为IntBuffer对象分配空间
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 向IntBuffer对象中写入数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        // warning！！！ 读写切换，不切换会无法继续走
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
        System.out.println("===========================================");
        ByteBuffer byteBuffer = ByteBuffer.allocate(2000);

        byteBuffer.put("hello".getBytes());
        System.out.println(byteBuffer.limit()); // 最大可读或可写的位置
        System.out.println(byteBuffer.position()); // 位置|坐标
        System.out.println(byteBuffer.capacity()); // 容量
        System.out.println(byteBuffer.mark());  // 标记

        byteBuffer.flip();
    }
}
