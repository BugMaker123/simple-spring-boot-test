package com.example.simplespringboottest.prac.practice.demos.mult._09_并发类容器.延时队列;

import java.util.concurrent.DelayQueue;

public class 网吧 implements Runnable{
	private DelayQueue<小屁孩儿> queue = new DelayQueue<小屁孩儿>();
	public boolean 提示音 = true;
	
	public void 上机(String name,String id,int money) {
		小屁孩儿 小孩儿 = new 小屁孩儿(name,id,1000*money+System.currentTimeMillis());
		System.err.println("网名："+小孩儿.getName()+"\t身份证："+小孩儿.getId()+"\t交了"+money+"块钱，现在开始上机");
		this.queue.add(小孩儿);
	}
	public void 下机(小屁孩儿 小孩儿) {
		System.err.println("网名："+小孩儿.getName()+"\t身份证："+小孩儿.getId()+"时间到了，下机了...");
		
	}

	@Override
	public void run() {
	while(提示音) {
			try {
				小屁孩儿 小孩儿 = queue.take();
				下机(小孩儿);
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			System.err.println("网吧开始营业");
			网吧 黑网吧 = new 网吧();
			Thread 上网 = new Thread(黑网吧);
			上网.start();
			
			黑网吧.上机("大毛儿", "123123", 1);
			黑网吧.上机("鼻涕虫", "456456", 10);
			黑网吧.上机("二狗子", "789789", 5);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
