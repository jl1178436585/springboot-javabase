package com.jl.thread.wait;


/**
 * 调用Thread.wait(3000)表示线程等待3秒之内，没有其他线程唤醒这个处于等待状态的线程，那么线程就会自动唤醒
 * @author jl
 *
 */
public class ThreadA extends Thread{

	private Object object;
	
	public ThreadA(Object object) {
		this.object = object;
	}
	
	@Override
	public void run() {
		synchronized (object) {
			System.out.println("wait begin--" + Thread.currentThread().getName());
			try {
				object.wait(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("wait end--" + Thread.currentThread().getName());
		}
		
	}
	
	
}
