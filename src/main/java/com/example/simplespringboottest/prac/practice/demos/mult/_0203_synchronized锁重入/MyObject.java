package com.example.simplespringboottest.prac.practice.demos.mult._0203_synchronized锁重入;

public class MyObject {
	public synchronized void method01() {
		System.err.println("这里是方法一");
		this.method02();
	}
	public synchronized void method02() {
		System.err.println("这里是方法二");
		this.method03();
	}
	public synchronized void method03() {
		System.err.println("这里是方法三");
	}
	public static void main(String[] args) {
		final MyObject myObj = new MyObject();
		Thread thread = new Thread(new Runnable(){
				@Override
				public void run() {
					myObj.method01();
				}
		});
		thread.start();
	}
}
