package com.example.simplespringboottest.prac.practice.demos.mult._13_自定义线程池;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class 无界队列的线程池 implements Runnable {
	private static AtomicInteger count = new AtomicInteger(0);
	@Override
	public void run() {
		try {
			System.err.println("这是任务"+count.incrementAndGet());
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ExecutorService executor = new ThreadPoolExecutor(5,10,120l,TimeUnit.SECONDS,queue);
		for(int index = 0;index<50;index++) {
			executor.execute(new 无界队列的线程池());
		}
		
		int size = queue.size();
		while(size > 0 ) {
			Thread.sleep(1*1000);
			System.err.println("queue size is :"+size);
			size = queue.size();
		}
	}

}
