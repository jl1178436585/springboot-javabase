/*
 * @(#)FinalTestDemo1.java  
 */
package com.jl.vm.final1;

import java.util.Random;

/**
 *<p>
 *	如果一个类的常量是编译期常量（编译期间就能确定常量的值），那么使用这个常量时，就不会对这个类进行初始化
 *	如果一个类的常量是非编译期常量（编译期间就能不确定常量的值），那么使用这个常量时，就会对这个类进行初始化
 *</p>
 * @author: jl
 * @date: 2018/06/24
 * @version: v1.0
 */
class FinalTest2{
	/**
	 * 此处的x在代码编译期间补能确定值
	 */
	public static final int x = new Random().nextInt(100);
	
	static {
		System.out.println("FinalTest2静态代码块执行.....");
	}
}

public class FinalTestDemo2 {

	public static void main(String[] args) {
		System.out.println(FinalTest2.x);
	}
	
}
