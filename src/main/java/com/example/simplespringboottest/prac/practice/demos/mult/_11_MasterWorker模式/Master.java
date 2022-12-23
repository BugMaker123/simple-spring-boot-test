package com.example.simplespringboottest.prac.practice.demos.mult._11_MasterWorker模式;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//容器一：存放来自main的任务，这里涉及到并发，所以使用并发类容器
	private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<Task>();
	//容器二：存放Worker，由于有Master进行分配，使每一个Worker不存在并发，所以使用普通容器
	private HashMap<String,Thread> workerMap = new HashMap<String,Thread>();
	//容器三：存放Worker们的任务返回结果集，由于这里涉及到并发，所以使用并发类容器
	private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<String,Object>();
	
	//构造一个Master
	@SuppressWarnings("unused")
	private Master() {}
	public Master(Worker worker,int workerCount) {
		worker.setWorkQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		for(int index = 0;index < workerCount;index++) {
			this.workerMap.put(Integer.toString(index), new Thread(worker));
		}
	}
	//提交任务
	public void submit(Task task) {
		this.workQueue.add(task);
	}
	//启动Worker们去执行任务
	public void execute() {
		for(Map.Entry<String, Thread> me : workerMap.entrySet()) {
			me.getValue().start();
		}
	}
	//判断一个Worker是否运行结束
	public boolean isComplete() {
		for(Map.Entry<String, Thread> me : workerMap.entrySet()) {
			if(me.getValue().getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}
	//计算结果
	public int getResult() {
		int priceResult = -1;
		for(Map.Entry<String, Object> me : resultMap.entrySet()) {
			priceResult += (Integer)me.getValue();
		}
		return priceResult;
	}

}
