package com.jl.thread.volatile1;

public class Test {

	public static void main(String[] args) {
		Service service = new Service();
		ThreadRun threadRun = new ThreadRun(service);
		ThreadStop stop = new ThreadStop(service);
		
		new Thread(threadRun).start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(stop).start();
	}
	
}
