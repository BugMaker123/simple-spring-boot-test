package com.example.simplespringboottest.prac.practice.demos.mult._07_线程间通讯问题;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class 模拟阻塞队列 {
	//使用LinkedList集合来装元素
	private LinkedList<Object> linkList = new LinkedList<Object>();
	//计数器,限制list的容量
	private AtomicInteger count = new AtomicInteger(0);
	//规定上/下限
	private final int maxSize;
	private final int minSize = 0;
	//构造队列
	public 模拟阻塞队列(int size) {
		this.maxSize = size;
	}
	//初始化一个锁
	private final Object lock = new Object();
	//模拟put方法
	public void put(Object e) {
		synchronized (lock) {
			while(count.get() == this.maxSize) {
				try {
					lock.wait();
				}catch(Exception exception) {
					System.err.println(exception.getMessage());
				}
			}
			if(linkList.add(e)) {							//添加Object
				count.incrementAndGet();			//计数器累加
				lock.notify(); 								//唤醒take方法
				System.err.println("新添加："+e);
			}
			
		}
	}
	//模拟take方法
	public Object take() {
		synchronized (lock) {
			while(count.get() == this.minSize) {
				try {
					lock.wait();
				}catch(Exception exception) {
					System.err.println(exception);
				}
			}
			Object object = linkList.removeFirst();
			if(object != null) {							//取出成功
				count.decrementAndGet();			//计数器累减
				lock.notify(); 								//唤醒put方法
			}
			return object;
		}
	}
	public static void main(String[] args) {
		//初始化队列
		final 模拟阻塞队列 blockingQueue = new 模拟阻塞队列(5);
		blockingQueue.put("赵");
		blockingQueue.put("钱");
		blockingQueue.put("孙");
		blockingQueue.put("李");
		blockingQueue.put("，");
		System.err.println("当前长度为："+blockingQueue.count.get());
		
		Thread thread_put = new Thread(new Runnable() {
				@Override
				public void run() {
						blockingQueue.put("周");blockingQueue.put("吴");blockingQueue.put("郑");blockingQueue.put("王");blockingQueue.put("。");
				}
			},"thread_put");
		thread_put.start();
		
		try {
			Thread.sleep(3*1000);
		}catch(Exception exception) {
			System.err.println(exception.getMessage());
		}
		
		Thread thread_take = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int index=1;index<6;index++)
					System.err.println("第"+index+"个移除的Object为"+blockingQueue.take());
			}
		},"thread_take");
		thread_take.start();
	}
}
