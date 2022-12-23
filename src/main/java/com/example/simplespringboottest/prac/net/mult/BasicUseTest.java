package com.example.simplespringboottest.prac.net.mult;

/**
 * 基本的语法与说明尝试,notify,wait,notifyAll,join,sleep,yield
 */
public class BasicUseTest {

    static class MThread extends Thread {
        public synchronized void getThreadWait() {
            try {
                wait(2000);
                System.out.println("线程阻塞");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void getThreadNotify() {
            try {
                notify();
                System.out.println("唤醒线程");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("线程启动");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程结束");
        }

        public static void main(String[] args) throws InterruptedException {
            MThread mThread = new MThread();
            mThread.start();
            System.out.println("线程状态" + mThread.getState());
            mThread.getThreadWait();
            mThread.getThreadNotify();
        }
    }
}