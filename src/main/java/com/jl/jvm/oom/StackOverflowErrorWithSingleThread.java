/*
 * @(#)StackOverflowError.java  
 */
package com.jl.jvm.oom;
/**
 *<p>
 *	单线程测试StackOverflowError:
 *
 *VM args: -Xss128k
 *
 *</p>
 * @author: jl
 * @date: 2018/08/19
 * @version: v1.0
 */
public class StackOverflowErrorWithSingleThread {

	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		StackOverflowErrorWithSingleThread stackOverflow = new StackOverflowErrorWithSingleThread();
		try {
			stackOverflow.stackLeak();
		} catch (Throwable e) {
			System.out.println("栈的深度是:" + stackOverflow.stackLength);
//			e.printStackTrace();
		}
	}
	
}
