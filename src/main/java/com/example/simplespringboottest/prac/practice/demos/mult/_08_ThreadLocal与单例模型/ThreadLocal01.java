package com.example.simplespringboottest.prac.practice.demos.mult._08_ThreadLocal与单例模型;

public class ThreadLocal01 {
	public static ThreadLocal<String> thread = new ThreadLocal<String>();
	@SuppressWarnings("static-access")
	public void getThread() {
		System.err.println(Thread.currentThread().getName()+":"+this.thread.get());
	}
	public void setThread(String value) {
		thread.set(value);
	}
	public static void main(String[] args) {
		final ThreadLocal01 thread01 = new ThreadLocal01();
		Thread thread1 = new Thread(new Runnable() {
			@Override	
			public void run() {
				thread01.setThread("张三");
				thread01.getThread();
				}
			},"thread1");
		Thread thread2 = new Thread(new Runnable() {
			@Override	
			public void run() {
					try {
						Thread.sleep(3*1000);
						thread01.getThread();
					} catch (InterruptedException e) {
						System.err.println(e.getMessage());
					}
				}
			},"thread2");
		thread1.start();
		thread2.start();
	}
}
