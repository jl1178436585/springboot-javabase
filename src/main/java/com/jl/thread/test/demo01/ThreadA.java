package com.jl.thread.test.demo01;

public class ThreadA extends Thread{

	private Person p;
	
	public ThreadA(Person p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		p.say("a");
	}
}
