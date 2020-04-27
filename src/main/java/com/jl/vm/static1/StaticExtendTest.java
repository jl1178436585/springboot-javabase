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

class Parent{
	static int a = 3;
	static {
		System.out.println("Parent静态代码块........");
	}
}

class Child extends Parent{
	static int b = 4;
	static {
		System.out.println("Child 静态代码块.......");
	}
}

public class StaticExtendTest {

	static {
		System.out.println("Main 静态代码块.........");
	}
	
	public static void main(String[] args) {
		System.out.println(Child.b);
	}
	
	
	
	/**
	 * 结果：
	 * 
	 * Main 静态代码块.........
		Parent静态代码块........
		Child 静态代码块.......
		4

	 */
	
}
