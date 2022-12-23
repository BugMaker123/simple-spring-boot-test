package com.example.simplespringboottest.prac.practice.demos.mult._13_自定义线程池;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class 自定义拒绝策略 implements RejectedExecutionHandler{
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("嘀 ___好人卡");
	}

}
