package com.example.simplespringboottest.prac.first.mult.volatileTest;

import static jodd.util.ThreadUtil.sleep;

/**
 * volatile只保证 可以及时读取到修改，不加volatile别的线程也是可以读取到的（读取到了CPU缓存的值）,只是不及时
 *
 * 空循环的指令集的优先级很高，里面的数据有任何修改都会及时发现
 */
public class VolatileTestProFinal {
    public static volatile boolean flag = false;

    public static int count = 0;

    void method(){
        System.out.println(Thread.currentThread().getName()+"-----"+flag+"=="+count);
    }

    public static void main(String[] args) {

        VolatileTestProFinal pro = new VolatileTestProFinal();
        new Thread(()->{
            while (!flag){
                count++;
            }
            System.out.println(count);
        },"t1").start();
        sleep(2000);
        new Thread(pro::method,"t2").start();
        new Thread(pro::method,"t3").start();

    }
}
