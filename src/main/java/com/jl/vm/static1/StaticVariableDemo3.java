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


public class StaticVariableDemo3 {
	
	public static int a = 1;
	
	static {
		a = 3;
		b= 3;
		
		//Cannot reference a field before it is defined
		//静态语句块只能访问定义在他之前的静态变量，定义在他之后的只能赋值不能访问
//		System.out.println(b);
	}
	
	public static int b;
	
	static {
		a = 5;
		b= 5;
	}
	
	public static void main(String[] args) throws Exception {
	
		Class<?> forName = Class.forName(String.class.getName());
		System.out.println(forName.getClassLoader());//null，根类加载器加载
		
		Class<?> forName1 = Class.forName(StaticVariableDemo3.class.getName());
		System.out.println(forName1.getClassLoader());
		
		System.out.println(StaticVariableDemo3.a);
		System.out.println(StaticVariableDemo3.b);
		
	}
	
}
