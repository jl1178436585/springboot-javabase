package com.jl.thread.test;

public class Dog {

	private String name;
	
	public synchronized void say(){
		System.out.println("say()------start---" + Thread.currentThread().getName());
		method3();
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("say()------end--" + Thread.currentThread().getName());
	}
	
	
	public synchronized void hi(){
		System.out.println("hi()------start---" + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hi()------end---" + Thread.currentThread().getName());
	}

	public void method3(){
		for (int i = 0; i < 100; i++) {
			System.out.println("3=" +Thread.currentThread().getName());
		}
		System.out.println("method3--------------");
	}
}
