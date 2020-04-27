package com.jl.thread.test.demo01;

public class Person {

	private String name;
	private int age;
	
	public void say(String word){
		if("a".equals(word)){
			age = 20;
		}else if("b".equals(word)){
			age = 25;
		}
		System.out.println(Thread.currentThread().getName() + "|" + age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
