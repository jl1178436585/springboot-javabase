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

class Parent2{
	static int a = 3;
	static {
		System.out.println("Parent2静态代码块........");
	}
}

class Child2 extends Parent2{
	static int b = 4;
	static {
		System.out.println("Child2 静态代码块.......");
	}
}

public class StaticExtendTest2 {

	static {
		System.out.println("StaticExtendTest2--Main 静态代码块.........");
	}
	
	public static void main(String[] args) {
		Parent2 parent;
		System.out.println("-----------------");
		
		parent = new Parent2();
		System.out.println("Parent2.a=" +Parent2.a);
		System.out.println("Child2.b=" + Child2.b);
	}
	
	
	
	/**
	 * 结果：
	 * 
	 * StaticExtendTest2--Main 静态代码块.........
		-----------------
		Parent2静态代码块........
		Parent2.a=3
		Child2 静态代码块.......
		Child2.b=4

	 */
	
}
