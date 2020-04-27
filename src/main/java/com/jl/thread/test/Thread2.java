package com.jl.thread.test;

public class Thread2 extends Thread{

	private Dog dog;
	
	public Thread2(Dog dog){
		this.dog = dog;
	}
	
	@Override
	public void run() {
		System.out.println("run--start");
		dog.say();
		int a = 6 / 0;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("run--finish");
	}
	
	

}
