/*
 * @(#)StaticExtendTest.java  
 */
package com.jl.vm.static1;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/24
 * @version: v1.0
 */

class Parent3{
	static int a = 3;
	static {
		System.out.println("Parent3静态代码块........");
	}
	public static void doSomething() {
		System.out.println("Parent3 doSomething.........");
	}
}

class Child3 extends Parent3{
	static {
		System.out.println("Child3 静态代码块.......");
	}
}

public class StaticExtendTest3 {

	
	public static void main(String[] args) {
		System.out.println(Child3.a);
		Child3.doSomething();
	}
	
	
	
	/**
	 * 结果：
	 * 

	 */
	
}
