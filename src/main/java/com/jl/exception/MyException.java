package com.jl.exception;

public class MyException extends RuntimeException{

	private static final long serialVersionUID = 1868145327431267341L;
	
	public MyException(String msg) {
		super(msg);
	}

}
