package com.example.simplespringboottest.prac.practice.demos.mult._08_ThreadLocal与单例模型;

public class Singleton {
	private static class InnerSingleton{
		private static Singleton single = new Singleton();
	}
	public static Singleton getInstance() {
		return InnerSingleton.single;
	}
}
