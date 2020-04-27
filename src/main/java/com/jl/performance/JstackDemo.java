package com.jl.performance;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class JstackDemo{

	private static Executor executor  = Executors.newFixedThreadPool(5);
	public static Object lock = new Object();
	
	public static void main(String[] args) {
		CalcThread c1 = new CalcThread();
		CalcThread c2 = new CalcThread();
		
		executor.execute(c1);
		executor.execute(c2);
		
	}
	

}
