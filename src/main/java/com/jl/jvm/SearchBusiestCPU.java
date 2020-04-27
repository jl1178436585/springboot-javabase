/*
 * @(#)SearchBusiestCPU.java  
 */
package com.jl.jvm;

/**
 * <p>
 * JVM命令演示：
 * 	1. jps(JVM Process Status Tool),显示指定系统内所有的HotSpot虚拟机进程
 * 
 * </p>
 * 
 * @author: jl
 * @date: 2018/07/24
 * @version: v1.0
 */
public class SearchBusiestCPU {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					try {
						Thread.sleep(100000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
		Thread t = new Thread() {

			public void run() {
				int i = 0;
				while (true) {
					i = (i++) / 100;
				}
			}
		};
		t.setName("Buiest thread");
		t.start();
	}
}
