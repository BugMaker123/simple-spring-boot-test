package com.example.simplespringboottest.prac.practice.demos.mult._10_Futrue设计模式;

//import java.util.concurrent.Future;

public class FutrueClient {
	public Data request(final String queryStr) {
		//Future futrue = null;
		
		//先有一个代理对象（Data的实现类）返回给发送请求的客户端，使该客户端继续做其他事情
		final FutrueData futrueData = new FutrueData();
		//启动线程，加载真实的数据传给此代理对象
		new Thread(new Runnable() {
			@Override
			public void run() {
				//新的线程自个去加载真实数据，然后传给代理对象
				try {
					System.err.println("新的线程自个去加载真实数据，然后传给代理对象,整个过程将用时5秒");
					Thread.sleep(5*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				RealData realData = new RealData(queryStr);
				futrueData.setRealData(realData);
			}
		}).start();
		return futrueData;
	}
}
