package com.example.simplespringboottest.prac.first.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何触发内存溢出?
 * 创建超过内存大小的对象进行加载
 */
public class OOMTest {
    public static void main(String[] args) {
        //返回java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        //返回java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Total_Memory(-Xms ) =  "+ totalMemory + " 字节  " + (totalMemory / (double)1024/1024)+"MB");
        System.out.println("Max_Memory(-Xmx ) =  "+ maxMemory + " 字节  " + (maxMemory / (double)1024/1024)+"MB");
        int i = 1;
        List<byte[]> list = new ArrayList<byte[]>();

        while (true) {
            list.add(new byte[10 * 1024 * 1024]);
            System.out.println("第" + (i++) + "次分配");
        }


    }
}
