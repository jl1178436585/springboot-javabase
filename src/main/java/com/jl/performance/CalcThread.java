package com.jl.performance;

public class CalcThread implements Runnable{

	public static Object lock = new Object();
	
	@Override
	public void run() {

		synchronized (lock) {
			calc();
		}
		
	}
	
	public void calc(){
		int i = 0;
		while(true){
			i++;
		}
	}
	
}
