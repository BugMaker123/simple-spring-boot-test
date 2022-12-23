package com.example.simplespringboottest.prac.practice.demos.mult._08_ThreadLocal与单例模型;

public class SingleTonTest {

	public static void main(String[] args) {
		Singleton s1 = new Singleton();
		Singleton s2 = new Singleton();
		Singleton s3 = new Singleton();
		Singleton s4 = new Singleton();
System.err.println(s1.hashCode());
System.err.println( s2.hashCode() );
System.err.println( s3.hashCode() );
System.err.println( s4.hashCode());
	}

}
