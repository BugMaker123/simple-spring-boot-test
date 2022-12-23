package com.example.simplespringboottest.prac.practice.demos.mult._13_自定义线程池;

public class MyTask implements Runnable{
	private int taskId;
	private String taskName;
	
	@SuppressWarnings("unused")
	private MyTask() {}
	public MyTask(int taskId,String taskName) {
		this.taskId = taskId;
		this.taskName = taskName;
	}
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	@Override
	public String toString() {
		return "MyTask [taskId=" + taskId + ", taskName=" + taskName + "]";
	}
	@Override
	public void run() {
		try {
			System.err.println(toString());
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
