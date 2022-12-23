package com.example.simplespringboottest.prac.practice.demos.mult._10_Futrue设计模式;

public class FutrueTest {
	public static void main(String[] args) {
		FutrueClient client = new FutrueClient();
		Data data = client.request("请求参数");
		System.err.println("请求发出了，现在我正在干一些其他的事情。。。");
		long startTime = System.currentTimeMillis();
		String result = data.getRequest();
		System.err.println("这里其实是被阻塞了吗？该方法用时："+(System.currentTimeMillis()-startTime)/1000+"秒");
		System.err.println("突然想起来我还有一些数据需要接收，他们是："+result);
	}
}
