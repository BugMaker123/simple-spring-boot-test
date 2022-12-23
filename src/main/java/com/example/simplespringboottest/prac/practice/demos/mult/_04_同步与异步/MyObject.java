package com.example.simplespringboottest.prac.practice.demos.mult._04_同步与异步;

public class MyObject{
	public synchronized void method01() {
		System.err.println(Thread.currentThread().getName()+"我是被锁住的方法");
		try {
			Thread.sleep(5*1000);			//睡4秒钟
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void method2() {
		System.err.println(Thread.currentThread().getName()+"我还没有被锁住");
		try {
			Thread.sleep(1*1000);				//睡1秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		final MyObject myObj = new MyObject();
		Thread thread1 = new Thread(new Runnable() {
				@Override
				public void run() {
					myObj.method01();
				}
			},"thread1");
		Thread thread2 = new Thread(new Runnable() {
				@Override
				public void run() {
					myObj.method2();
				}
			},"thread2");
		Thread thread3 = new Thread(new Runnable() {
				@Override
				public void run() {
					myObj.method01();
				}
			},"thread3");
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
}
