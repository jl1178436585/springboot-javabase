package com.jl.thread.wait;

public class Test {

	public static void main(String[] args) {
		Object object = new Object();
		ThreadA a = new ThreadA(object);
		a.start();
	}
	
}
