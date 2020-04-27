package com.jl.thread.test.demo01;

public class ThreadB extends Thread{

	private Person p;
	
	public ThreadB(Person p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		p.say("b");
	}
}
