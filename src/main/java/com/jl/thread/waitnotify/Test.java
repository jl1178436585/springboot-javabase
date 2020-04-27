package com.jl.thread.waitnotify;

public class Test {

	/**
	 * wait 开始--Thread-0
		notify 开始--Thread-2
		notify 结束--Thread-2
		notify 开始--Thread-1
		notify 结束--Thread-1
		wait 结束--Thread-0
		
或者
		wait 开始--Thread-0
		notify 开始--Thread-1
		notify 结束--Thread-1
		wait 结束--Thread-0
		notify 开始--Thread-2
		notify 结束--Thread-2

或者
		notify 开始--Thread-1
		notify 结束--Thread-1
		notify 开始--Thread-2
		notify 结束--Thread-2
		wait 开始--Thread-0
		一直在等待

	 * @param args
	 */
	public static void main(String[] args) {
		
		Object lock = new Object();
		ThreadA threadA = new ThreadA(lock);
		threadA.start();
		
		NotifyThreadA notifyThreadA = new NotifyThreadA(lock);
		notifyThreadA.start();
		
		NotifyThreadB notifyThreadB = new NotifyThreadB(lock);
		notifyThreadB.start();
		
	}
	
}
