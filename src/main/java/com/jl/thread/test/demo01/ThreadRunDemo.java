package com.jl.thread.test.demo01;

public class ThreadRunDemo {
	
	public static void main(String[] args) {
		
		Person p = new Person();
		new ThreadA(p).start();
		new ThreadB(p).start();
		
		
		
		
		
//		new ThreadA(p).start();
		
		
	}
	
}
