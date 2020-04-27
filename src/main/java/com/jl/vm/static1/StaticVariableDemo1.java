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

class Singleton{
	
	public static int count1 = 1;
	public static int count2 = 0;
	
	private static Singleton instance = new Singleton();
	
	private Singleton() {
		count1++;
		count2++;
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
}

public class StaticVariableDemo1 {
	
	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		System.out.println(instance.count1);
		System.out.println(instance.count2);
		
	}
	
}
