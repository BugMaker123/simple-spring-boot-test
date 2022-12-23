package com.example.simplespringboottest.prac.practice.demos.mult._13_自定义线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 有界队列的线程池 {

	public static void main(String[] args) {
		//自定义线程池：核心线程数1、最大线程数2、时间组合：数量6、时间组合：单位秒、任务队列(有界队列)：数量3、自定义拒绝策略
		ThreadPoolExecutor myPool = new ThreadPoolExecutor(1,	2,	6,	TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(3),new 自定义拒绝策略());
		//任务
		MyTask task1 = new MyTask(1,"张三提交的任务：吃饭");
		MyTask task2 = new MyTask(2,"李四提交的任务：睡觉");
		MyTask task3 = new MyTask(3,"王五提交的任务：写BUG");
		MyTask task4 = new MyTask(4,"赵六提交的任务：钱七，你今天带药了吗？");
		MyTask task5 = new MyTask(5,"钱七提交的任务：今天我带的是速效救心丸！");
		MyTask task6 = new MyTask(6,"吕八提交的任务：我是秀才，我要去找芙妹！");
		//线程池执行任务
		myPool.execute(task1);
		myPool.execute(task2);
		myPool.execute(task3);
		myPool.execute(task4);
		myPool.execute(task5);
		myPool.execute(task6);
		//优雅关机
		myPool.shutdown();
	}

}
