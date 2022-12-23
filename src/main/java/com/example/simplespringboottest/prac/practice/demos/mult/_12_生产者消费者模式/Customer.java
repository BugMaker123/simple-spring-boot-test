package com.example.simplespringboottest.prac.practice.demos.mult._12_生产者消费者模式;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
	// 设置内存缓存区
	BlockingQueue<Data> messageQueue;
	@SuppressWarnings("unused")
	private Customer() {}
	public Customer(BlockingQueue<Data> messageQueue) {
		this.messageQueue = messageQueue;
	}
	//随机对象
	private static Random r = new Random();
	
	@Override
	public void run() {
		while(true) {
			try {
				//获取数据
				Data data = this.messageQueue.take();
				//进行数据处理
				Thread.sleep(r.nextInt(3)*1000);
				System.err.println("当前线程(消费者):"+Thread.currentThread().getName()+"消费成功，消费数据Id为:"+data.getId());
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}

}
