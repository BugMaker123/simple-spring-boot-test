package com.example.simplespringboottest.prac.practice.demos.mult._08_同步类容器;

import java.util.LinkedList;
import java.util.List;

public class 容器的synchronizedX方法 {
	public static void main(String[] args) {
		final List<String> strList = new LinkedList<String>();																	    //普通的容器
		//初始化strList
		for(int index=0;index<1000;index++)			strList.add("赵"+index);
		//多个线程开始操作
		for(int i = 1;i < 9;i++) {
			new Thread("线程"+i) {
				public void run() {
					while(true) {
						if(strList.isEmpty()) break;
						System.err.println(Thread.currentThread().getName()+"----"+strList.remove(0));
					}
				}
			}.start();
		}
		System.err.println("每次只有一个线程访问-->避免出现多个线程同时对同一资源操作的异常");
	}
}
