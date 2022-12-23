package com.example.simplespringboottest.prac.practice.demos.mult._06_volatile关键字;

public class MyObject extends Thread{

	//private volatile boolean isRunning = true;
	private boolean isRunning = true;
	public void setRuning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public void run() {
		System.err.println("进入run方法...");
		while(isRunning == true) {
			System.err.println("run一直在奔跑...\t.");
		}
		System.err.println("isRunning = "+isRunning);
		System.err.println("run终于停止了奔跑");
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyObject myObj = new MyObject();
		myObj.start();
		Thread.sleep(2*1000);
		myObj.setRuning(false);
		System.err.println("总部叫你停下来");
		Thread.sleep(1*1000);
		System.err.println(myObj.isRunning);
	}

}
