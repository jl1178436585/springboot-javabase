package com.jl.exception;

import java.util.Random;

import org.junit.Test;

public class ExceptionTest {
	
	
	public static void test1(){
		try {
			System.out.println(11111);
			Random random = new Random();
			int a = random.nextInt(10);
			System.out.println("a=" + a);
			if(a > 2){
				throw new MyException("1>0----exception");
			}
			System.out.println(333333);
		} catch (Exception e) {
			System.out.println("222222222222");
			throw new MyException(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		test1();
	}
	
	
}
