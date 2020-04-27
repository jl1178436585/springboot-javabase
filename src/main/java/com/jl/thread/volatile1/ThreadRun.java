package com.jl.thread.volatile1;

public class ThreadRun implements Runnable{

	private Service service;
	
	public ThreadRun(Service service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		this.service.run();
	}

}
