package com.example.simplespringboottest.prac.practice.demos.mult._11_MasterWorker模式;

import java.util.Random;

public class MyTest {
	public static void main(String[] args) {
		Master master = new Master(new Worker(),1000);
		Random r = new Random(System.currentTimeMillis());
		for(int index = 1;index < 1001;index++) {
			//20个worker：10-5;20-5;30-10;40-10;50-15;60-15;100-25;1000-250
			//200个worker：1000-25
			//1000个worker：1000-5
			//2000个worker：1000-4
			Task task = new Task();
			task.setId(index);
			task.setPrice(r.nextInt(1000));
			master.submit(task);
		}
		System.err.println("下面开始执行任务");
		master.execute();
		long start = System.currentTimeMillis();
		while(true) {
			if(master.isComplete()) {
				long spend = System.currentTimeMillis() - start;
				int priceResult = master.getResult();
				System.err.println("最终结果："+priceResult+"，执行时间:"+spend/1000+"秒");
				break;
			}
		}
	}
}
