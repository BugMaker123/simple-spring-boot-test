package com.example.simplespringboottest.prac.practice.demos.mult._11_MasterWorker模式;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String,Object> resultMap;
	
	public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
	}
	public void setResultMap(ConcurrentHashMap<String,Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	@Override
	public void run() {
		while(true) {
			Task input = this.workQueue.poll();
			if(input == null) break;
			Object output = handle(input);
			this.resultMap.put(Integer.toString(input.getId()), output);
		}
	}
	private Object handle(Task input) {
		Object output = null;
		try {
			//假设处理一个任务耗时5秒
			Thread.sleep(5*1000);
			output = input.getPrice();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return output;
	}
}
