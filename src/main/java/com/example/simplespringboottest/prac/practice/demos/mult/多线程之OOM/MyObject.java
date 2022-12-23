package com.example.simplespringboottest.prac.practice.demos.mult.多线程之OOM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyObject {
	
	public void method1() {
		 while(true){
		        System.out.println(new Date().toString()+Thread.currentThread()+"==");
		        try {
		            Thread.sleep(1000);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	}
	
	public void method2() {
		 List<byte[]> list=new ArrayList<byte[]>();
		    while(true){
		        System.out.println(new Date().toString()+Thread.currentThread()+"==");
		        byte[] b = new byte[1024*1024*512];
		        list.add(b);
		        System.err.println("已经申请了:"+list.size()/2+"G内存");
		        try {
		            Thread.sleep(1000);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	}

	public static void main(String[] args) {
		final MyObject mo1 = new MyObject();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo1.method1();
			}
		});
		final MyObject mo2 = new MyObject();
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo2.method2();
			}
		});
		thread1.start();
		thread2.start();
	}

}
