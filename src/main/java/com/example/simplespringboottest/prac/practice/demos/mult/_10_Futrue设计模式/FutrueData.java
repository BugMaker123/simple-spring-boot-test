package com.example.simplespringboottest.prac.practice.demos.mult._10_Futrue设计模式;

public class FutrueData implements Data{
	private RealData realData;
	private boolean flag = false;

	public synchronized void setRealData(RealData realData) {
		//如果数据已经装载完毕了就直接返回
		if(flag) {
			return;
		}else {
			//还没有装载完成，继续装载数据
			this.realData = realData;
			flag = true;
			//通知数据装载完成
			notify();
		}
	}
	
	@Override
	public synchronized String getRequest() {
		//如果数据没有装载完成，程序就一直处于阻塞状态
		while(!flag) {
			try {
				wait();
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		//如果数据已经装载完成就直接返回
		return this.realData.getRequest();
	}

}
