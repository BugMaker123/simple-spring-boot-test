package com.example.simplespringboottest.prac.practice.demos.mult._10_Futrue设计模式;

public class RealData implements Data{
	private String result;
	public RealData(String queryStr) {
		System.err.println("我在RealData里边，我假装在认真获取数据，其实只是在睡觉。。。估计要睡5秒钟");
		try {
			Thread.sleep(5*1000);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		System.err.println("装不下去了，赶紧起来干活吧");
		result = "我要起床工作了...";
	}
	@Override
	public String getRequest() {
		return result;
	}

}
