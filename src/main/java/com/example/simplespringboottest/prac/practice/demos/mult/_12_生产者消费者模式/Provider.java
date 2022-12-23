package com.example.simplespringboottest.prac.practice.demos.mult._12_生产者消费者模式;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable {
	// 设置内存缓存区
	BlockingQueue<Data> messageQueue;
	//多线程开关
	private volatile boolean isRunning = true;
	//id生成器
	private static AtomicInteger count = new AtomicInteger();
	//随机对象
	private static Random r = new Random(System.currentTimeMillis()); 
	
	@SuppressWarnings("unused")
	private Provider() {}
	public Provider(BlockingQueue<Data> messageQueue) {
		this.messageQueue = messageQueue;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			try {
				//随机睡眠，表示获取数据所产生的时间
				Thread.sleep(r.nextInt(5)*1000);
				//累计获取的数据
				int id = count.incrementAndGet();
				//获取Data
				Data data  = new Data(Integer.toString(id),"数据："+id);
				System.err.println("当前线程(生产者)"+Thread.currentThread().getName()+",获取了数据,id为："+id+",将其加载到公共缓存");
				messageQueue.add(data);
				if(!this.messageQueue.offer(data,2,TimeUnit.SECONDS)){
					System.err.println("提交缓冲区数据失败...");
				}
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	public void stop() {
		this.isRunning = false;
	}
}
