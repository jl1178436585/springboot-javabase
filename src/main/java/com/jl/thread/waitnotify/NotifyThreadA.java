package com.jl.thread.waitnotify;

public class NotifyThreadA extends Thread{

	private Object lock;
	
	public NotifyThreadA(Object lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		Service service = new Service();
		service.synNotifyMethod(lock);
	}
	
}
