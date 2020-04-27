/*
 * @(#)MyBean.java  
 */
package com.jl.vm;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/26
 * @version: v1.0
 */
public class Dog {

	public Dog() {
		System.out.println("Dog classLoader:" + this.getClass().getClassLoader());
	}
		
}
