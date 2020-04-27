/*
 * @(#)CloneObj.java  
 */
package com.jl.clone;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/29
 * @version: v1.0
 */
public class CloneObj implements Cloneable{

	private String name;
	
	private int age;
	
	private Person p;
	

	public CloneObj(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		CloneObj other = new CloneObj(this.name,this.age);
		Person p1 = new Person(p.getSex());
		other.setP(p1);
		return other;
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

	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}
	
	
}
