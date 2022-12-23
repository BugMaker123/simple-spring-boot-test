package com.example.simplespringboottest.prac.practice.demos.mult._07_线程间通讯问题.非WaitAndNotify;

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
		Thread thread1 = new Thread(					//测试线程1
				new Runnable() {
					@Override
					public void run() {
						try {
							for(int index=0;index<10;index++) {
								test1.add();
								System.out.println("当前线程:"+Thread.currentThread().getName()+"添加了一个元素。。");
								Thread.sleep(1000);
							}
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
				},"thread1");
		Thread thread2 = new Thread(					//测试线程2
				new Runnable() {
					@Override
					public void run() {
						while(true) 
							if(test1.size() == 5) {
								System.out.println("当前线程收到通知："+Thread.currentThread().getName()+" list size = 5 ,停止本线程");
								throw new RuntimeException();
							}
					}
				},"thread2");
		thread1.start();
		thread2.start();
	}
}
