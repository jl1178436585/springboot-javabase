/*
 * @(#)FinallyDemo.java  
 */
package com.jl.finally1;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/08/11
 * @version: v1.0
 */
public class FinallyDemo {

	public void say() {
		try {
			System.out.println("1111111111");
			int i= 8 / 0;
			System.out.println("2222222222");
		} finally {
			System.out.println("finally----------");
		}
	}
	
}
