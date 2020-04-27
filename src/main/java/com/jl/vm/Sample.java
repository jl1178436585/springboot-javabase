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
public class Sample {

	private String name;
	
	private int age;
	
	private int v1 = 1;

	public Sample() {
		System.out.println("Sample classLoader:" + this.getClass().getClassLoader());
		
		//主动使用Dog
		new Dog();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getV1() {
		return v1;
	}

	public void setV1(int v1) {
		this.v1 = v1;
	}
	
	
	
}
