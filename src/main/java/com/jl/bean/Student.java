package com.jl.bean;

public class Student extends Person {

	private String sex;
	
	public Student(String name, int age) {
		super();
		setName(name);
		setAge(age);
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + getName() + ", age=" + getAge() + "]";
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}
	

	
	
}
