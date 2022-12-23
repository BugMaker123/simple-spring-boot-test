package com.example.simplespringboottest.prac.practice.demos.mult._12_生产者消费者模式;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MainTest {

	public static void main(String[] args) {
		// 设置内存缓存区
		BlockingQueue<Data> messageQueue = new LinkedBlockingQueue<Data>(10);
		//生产者
		Provider provider_01 = new Provider(messageQueue);     		 
		Provider provider_02 = new Provider(messageQueue);     		 
		Provider provider_03 = new Provider(messageQueue);    		 	 
		Provider provider_04 = new Provider(messageQueue);     	
		Provider provider_05 = new Provider(messageQueue);    
		Provider provider_06 = new Provider(messageQueue);   
		Provider provider_07 = new Provider(messageQueue);   
		Provider provider_08 = new Provider(messageQueue);    
		//消费者
		Customer customer_01 = new Customer(messageQueue); 		 
		Customer customer_02 = new Customer(messageQueue); 		 
		//创建一个线程池，一个缓存的线程池，可创建无穷的线程，没有任务时不创建线程，空闲线程存活时间为默认(60秒)
		ExecutorService cachePool = Executors.newCachedThreadPool();
		cachePool.execute(provider_05);
		cachePool.execute(provider_06);
		cachePool.execute(provider_07);
		cachePool.execute(provider_08);
		cachePool.execute(provider_04);
		cachePool.execute(customer_01);
		cachePool.execute(provider_03);
		cachePool.execute(customer_02);
		cachePool.execute(provider_02);
		cachePool.execute(provider_01);
		try {
			Thread.sleep(5*1000);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		provider_04.stop();
		provider_03.stop();
		provider_02.stop();
		provider_01.stop();
		provider_05.stop();
		provider_06.stop();
		provider_07.stop();
		provider_08.stop();
		try {
			Thread.sleep(2*1000);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
/*		cachePool.shutdown();
		cachePool.shutdownNow();*/
		
	}

}
