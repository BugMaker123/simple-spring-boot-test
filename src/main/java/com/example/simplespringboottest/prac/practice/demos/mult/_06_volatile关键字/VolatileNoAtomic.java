package com.example.simplespringboottest.prac.practice.demos.mult._06_volatile关键字;

import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileNoAtomic extends Thread{
	private static volatile int count_NoAtomic = 0;
	private static AtomicInteger count_Atomic = new AtomicInteger(0);
	private static void runTest() {
		for(int index=0;index<1000;index++) {
			//count_NoAtomic ++;
			count_Atomic.incrementAndGet();		//等价于++
		}
		System.err.println("count_NoAtomic: "+count_NoAtomic+"\tcount_Atomic:"+count_Atomic);
	}
	public void run() {runTest();}
	public static void main(String[] args) {
		int len = 10;
		VolatileNoAtomic[] arr = new VolatileNoAtomic[len];
		for(int i = 0;i<len;i++)
			arr[i] = new VolatileNoAtomic();
		for(VolatileNoAtomic v : arr) {
			v.start();
		}
	}
}
