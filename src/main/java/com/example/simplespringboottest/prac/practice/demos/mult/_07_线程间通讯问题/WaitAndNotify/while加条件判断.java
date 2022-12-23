package com.example.simplespringboottest.prac.practice.demos.mult._07_线程间通讯问题.WaitAndNotify;

import java.util.ArrayList;
import java.util.List;

public class while加条件判断 {
	private volatile static List<String> list = new ArrayList<String>();
	private void add() {
		list.add("hello");  	
	}
	private int size() {
		return list.size();
	}
	public static void main(String[] args) {
		final while加条件判断 test1 = new while加条件判断();
		final Object obj = new Object();
		Thread thread1 = new Thread(					//测试线程1
				new Runnable() {
					@Override
					public void run() {
							synchronized (obj) {
								try {
									for(int index=0;index<10;index++) {
										test1.add();
										Thread.sleep(500);
										System.out.println("当前线程:"+Thread.currentThread().getName()+"添加了一个元素。。"+test1.size());
										if(test1.size() == 5){
											System.err.println("发出通知");
											obj.notify();				//试图唤醒线程2
											Thread.sleep(3*1000);
										}
									} 
								}catch (InterruptedException e1) {
									System.err.println(e1.getMessage());
								}
							}
					}
				},"thread1");
		Thread thread2 = new Thread(					//测试线程2
				new Runnable() {
					@Override
					public void run() {
						synchronized (obj) {
								if(test1.size() < 5) {
										System.err.println("thread2进入睡眠"); 
										try {
											obj.wait();   //2进入睡眠
										} catch (InterruptedException e) {
											e.printStackTrace();
										}  
								}
								System.err.println("当前线程收到通知：起床吱了一声");
						}
					}
				},"thread2");
		thread2.start();
		try {
			Thread.sleep(1*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread1.start();
	}
}

