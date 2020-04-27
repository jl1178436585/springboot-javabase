package com.jl.thread.threadlocal;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal<String>{

	@Override
	protected String initialValue() {
		return new Date().getTime()+"  " + Thread.currentThread().getName();
	}
	
	
	
}
