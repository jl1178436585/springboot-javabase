/*
 * @(#)StaticVariableDemo1.java  
 */
package com.jl.vm.static1;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/24
 * @version: v1.0
 */

class Singleton1{
	
	private static Singleton1 instance = new Singleton1();
	
	public static int count1 = 1;
	public static int count2 = 0;
	
	
	private Singleton1() {
		count1++;
		count2++;
	}
	
	public static Singleton1 getInstance() {
		return instance;
	}
	
}

public class StaticVariableDemo2 {
	
	public static void main(String[] args) {
		Singleton1 instance = Singleton1.getInstance();
		System.out.println(instance.count1);
		System.out.println(instance.count2);
		
	}
	
}
