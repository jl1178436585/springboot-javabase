/*
 * @(#)StackOverflowError.java  
 */
package com.jl.jvm.oom;
/**
 *<p>
 *	多线程测试StackOverflowError:
 *
 *VM args: -Xss128k
 *
 *</p>
 * @author: jl
 * @date: 2018/08/19
 * @version: v1.0
 */
public class StackOverflowErrorWithMultThread {

	private void dontStop() {
		while(true){
			
		}
	}
	
	public void stackLeakByThread() {
		while(true) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					dontStop();
				}
			});
			t.start();
		}
	}
	
	public static void main(String[] args) {
		StackOverflowErrorWithMultThread oom = new StackOverflowErrorWithMultThread();
		oom.stackLeakByThread();
	}
	
}
