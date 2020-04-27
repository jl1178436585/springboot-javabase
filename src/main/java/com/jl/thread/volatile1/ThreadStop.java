package com.jl.thread.volatile1;

public class ThreadStop implements Runnable{

	private Service service;
	
	public ThreadStop(Service service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		this.service.stopRun();
	}

}
