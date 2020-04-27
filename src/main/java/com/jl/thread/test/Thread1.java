package com.jl.thread.test;

public class Thread1 extends Thread{

	private Dog dog;
	
	public Thread1(Dog dog){
		this.dog = dog;
	}
	
	@Override
	public void run() {
		dog.say();
		
	}
	
	

}
