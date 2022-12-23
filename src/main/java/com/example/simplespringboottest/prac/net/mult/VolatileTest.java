package com.example.simplespringboottest.prac.net.mult;

import static java.lang.Thread.sleep;

/**&
 * volatile关键字
 * 作用：
 *  1.保证可见性
 *  2.禁止指令重排
 */
public class VolatileTest {

    private static volatile int num = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            long time1 = System.currentTimeMillis();
            while (num == 0) {
                System.out.println(System.currentTimeMillis() - time1);
            }
            System.out.println("num = " + num);
        });

        Thread t2 = new Thread(()-> {
                try {
                    sleep(5000);
                    num ++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        });
        t2.start();
        t1.start();
    }
}
