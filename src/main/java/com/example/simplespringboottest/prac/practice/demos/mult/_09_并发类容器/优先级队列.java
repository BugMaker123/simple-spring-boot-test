package com.example.simplespringboottest.prac.practice.demos.mult._09_并发类容器;

import java.util.concurrent.PriorityBlockingQueue;

public class 优先级队列 {

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<Task>();
        Task t1 = new Task();
        t1.setId(2);
        t1.setName("我是t1");
        queue.add(t1);
        Task t2 = new Task();
        t2.setId(3);
        t2.setName("我是t2");
        queue.add(t2);
        Task t3 = new Task();
        t3.setId(1);
        t3.setName("我是t3");
        queue.add(t3);

        System.out.println("容器：" + queue);
        System.out.println(queue.take().getId());
        System.out.println("容器：" + queue);
        System.out.println(queue.take().getId());
        System.out.println("容器：" + queue);
        System.out.println(queue.take().getId());
    }

}
