/*
 * @(#)PersonObj.java  
 */
package com.jl.sort;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/07/22
 * @version: v1.0
 */
public class PersonObj implements Comparable<PersonObj>{

	private String name;
	
	public PersonObj(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(PersonObj o) {
		return this.getName().compareTo(o.getName());
	}
	
}
