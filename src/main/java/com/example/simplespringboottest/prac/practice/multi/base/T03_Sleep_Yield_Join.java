package com.example.simplespringboottest.prac.practice.multi.base;


/**
 * 线程的状态
 * @ ClassName: T03_Sleep_Yield_Join
 * @Author: legen
 * @Date: 2021/3/10
 */
public class T03_Sleep_Yield_Join {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getState());
        threadJoin();
    }

    private static class ThreadSleep{
        public static void main(String[] args) {
            new Thread(()->{
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName()+"sleep 200ms"+i+"times");
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    /**
     * 将当前线程挂起,剩余线程竞争,但是不关心后续具体是谁竞争到资源
     */
    private static class ThreadYield{
        public static void main(String[] args) {
            new Thread(()->{
                for (int i = 0; i < 100; i++) {
                    if (i%10==0) {
                        System.out.println(Thread.currentThread().getName() + "sleep 200ms" + i + "times");
                        Thread.yield();
                    }
                }
            }).start();
            new Thread(()->{
                for (int i = 0; i < 100; i++) {
                    if (i%10==0) {
                        System.out.println(Thread.currentThread().getName() + "yield" + i + "times");
                        Thread.yield();
                    }
                }
            }).start();
            new Thread(()->{
                for (int i = 0; i < 100; i++) {
                    if (i%10==0) {
                        System.out.println(Thread.currentThread().getName() + "yield" + i + "times");
                        Thread.yield();
                    }
                }
            }).start();
        }
    }
    /**
     * join
     */
     static void threadJoin(){
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+" join "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
         Thread t2 = new Thread(()->{
             try {
                 t1.join();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             for (int i = 0; i < 10; i++) {
                 try {
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+" join "+i);
             }
         });
         t2.start();
         t1.start();
    }
}
