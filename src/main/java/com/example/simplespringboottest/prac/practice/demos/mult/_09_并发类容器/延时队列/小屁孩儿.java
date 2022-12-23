package com.example.simplespringboottest.prac.practice.demos.mult._09_并发类容器.延时队列;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class 小屁孩儿 implements Delayed{
	private String id;
	private String name;
	private long endTime;
	private TimeUnit timeUnit = TimeUnit.SECONDS;
	
	public 小屁孩儿() {}
	
	public 小屁孩儿(String name,String id,long endTime) {
		this.name = name;
		this.id = id;
		this.endTime = endTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

	//相互比较用于排序
	@Override
	public int compareTo(Delayed o) {
		小屁孩儿 小孩儿 = (小屁孩儿) o;
		return this.getDelay(this.timeUnit) - 小孩儿.getDelay(this.timeUnit) > 0 ? 1 : 0 ;
	}
	//判断是否到了截止时间
	@Override
	public long getDelay(TimeUnit unit) {
		return endTime-System.currentTimeMillis();
	}
}
