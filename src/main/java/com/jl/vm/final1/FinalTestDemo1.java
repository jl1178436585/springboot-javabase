/*
 * @(#)FinalTestDemo1.java  
 */
package com.jl.vm.final1;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/24
 * @version: v1.0
 */
class FinalTest{
	
	/**
	 * x在代码编译期间就能确定值，是个编译期常亮
	 */
	public static final int x = 6/ 3;
	
	static {
		System.out.println("FinalTest静态代码块执行.....");
	}
}

public class FinalTestDemo1 {

	public static void main(String[] args) {
		System.out.println(FinalTest.x);
	}
	
}
