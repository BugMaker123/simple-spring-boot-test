package com.example.simplespringboottest.prac.practice.demos.mult._05_业务脏读;

public class DirtyRead {
	private String userName="txd";
	private String password="123";
	
	public synchronized void setValue(String username,String password) {
	//public void setValue(String username,String password) {
		this.userName = username;
		try {
			Thread.sleep(5*1000);
		}catch(InterruptedException e) {
			System.err.println(Thread.currentThread().getName()+"线程此时被打断了");
		}
		this.password = password;
		System.err.println("setVlaue的最终执行结果为:username="+username+",   password="+password);
	}
	public synchronized void getValue() {
		System.err.println("getValue的最终执行结果为:username="+this.userName+",   password="+this.password);
	}
	
	public static void main(String[] args) {
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(
				new Runnable() {
					@Override
					public void run() {
						dr.setValue("晓冬", "凛冬将至");
					}
				}
				);
		Thread t2 = new Thread(
				new Runnable() {
					@Override
					public void run() {
						dr.getValue();
					}
				}
				);
		t1.start();
		t2.start();
	
	
	}
}
