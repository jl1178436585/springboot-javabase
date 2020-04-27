package com.jl.thread.waitnotify;

public class Service {

	public void waitMethod(Object lock){
		synchronized (lock) {
			System.out.println("wait 开始--" + Thread.currentThread().getName());
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("wait 结束--" + Thread.currentThread().getName());
			
		}
	}
	
	public void synNotifyMethod(Object lock){
		synchronized (lock) {
			System.out.println("notify 开始--" + Thread.currentThread().getName());
			lock.notify();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("notify 结束--" + Thread.currentThread().getName());
		}
	}
	
}
