package com.jl.thread.threadlocal;

public class ThreadA extends Thread{

	private ThreadLocalExt localExt;
	
	public ThreadA(ThreadLocalExt localExt) {
		this.localExt = localExt;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("在ThreadA中取值：" + localExt.get());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
