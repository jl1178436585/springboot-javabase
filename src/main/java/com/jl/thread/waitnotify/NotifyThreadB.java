package com.jl.thread.waitnotify;

public class NotifyThreadB extends Thread{

	private Object lock;
	
	public NotifyThreadB(Object lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		Service service = new Service();
		service.synNotifyMethod(lock);
	}
	
}
