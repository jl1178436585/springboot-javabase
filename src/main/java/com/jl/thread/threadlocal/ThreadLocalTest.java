package com.jl.thread.threadlocal;

public class ThreadLocalTest {

	public static void main(String[] args) {
		
		ThreadLocalExt threadLocalExt = new ThreadLocalExt();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("在主线程中取值：" + threadLocalExt.get());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		ThreadA a = new ThreadA(threadLocalExt);
		a.start();
	}
	
}
