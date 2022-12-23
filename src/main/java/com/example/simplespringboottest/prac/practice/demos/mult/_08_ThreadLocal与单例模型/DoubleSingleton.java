package com.example.simplespringboottest.prac.practice.demos.mult._08_ThreadLocal与单例模型;

public class DoubleSingleton {
	private static DoubleSingleton ds;
	
	public static DoubleSingleton getDs() {
		if(ds == null) {
			try {
				System.err.println("初始化对象");
				Thread.sleep(2*1000);
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
			synchronized (DoubleSingleton.class) {
				if(ds == null) {
					ds = new DoubleSingleton();
				}
			}
		}
		return ds;
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println(DoubleSingleton.getDs().hashCode());
			}
		},"thread1");
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println(DoubleSingleton.getDs().hashCode());
			}
		},"thread2");
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println(DoubleSingleton.getDs().hashCode());
			}
		},"thread3");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
