package com.example.simplespringboottest.prac.math.vmTest;

public class GcTest {
    public static void main(String[] args) {
        byte[] b1,b2,b3,b4;
        // 当前放在Eden区
        b1 = new byte[28000*1024];
/*        Heap
        PSYoungGen      total 37888K, used 32608K [0x00000000d6200000, 0x00000000d8c00000, 0x0000000100000000)
        eden space 32768K, 99% used [0x00000000d6200000,0x00000000d81d81e8,0x00000000d8200000)
        from space 5120K, 0% used [0x00000000d8700000,0x00000000d8700000,0x00000000d8c00000)
        to   space 5120K, 0% used [0x00000000d8200000,0x00000000d8200000,0x00000000d8700000)
        ParOldGen       total 86016K, used 0K [0x0000000082600000, 0x0000000087a00000, 0x00000000d6200000)
        object space 86016K, 0% used [0x0000000082600000,0x0000000082600000,0x0000000087a00000)
        Metaspace       used 2985K, capacity 4486K, committed 4864K, reserved 1056768K
        class space    used 321K, capacity 386K, committed 512K, reserved 1048576K*/

        b2 = new byte[5000*1024];     // 此时 b1 会被分配到老年代
       /* Heap
        PSYoungGen      total 37888K, used 6376K [0x00000000d6200000, 0x00000000dac00000, 0x0000000100000000)
        eden space 32768K, 16% used [0x00000000d6200000,0x00000000d6734040,0x00000000d8200000)
        from space 5120K, 20% used [0x00000000d8200000,0x00000000d8306010,0x00000000d8700000)
        to   space 5120K, 0% used [0x00000000da700000,0x00000000da700000,0x00000000dac00000)
        ParOldGen       total 86016K, used 28008K [0x0000000082600000, 0x0000000087a00000, 0x00000000d6200000)
        object space 86016K, 32% used [0x0000000082600000,0x000000008415a010,0x0000000087a00000)
        Metaspace       used 2985K, capacity 4486K, committed 4864K, reserved 1056768K
        class space    used 321K, capacity 386K, committed 512K, reserved 1048576K*/

        b3 = new byte[5000*1024];     // 此时 b2 会被分配到老年代
    }
}
