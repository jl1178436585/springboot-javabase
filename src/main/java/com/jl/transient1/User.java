/*
 * @(#)User.java  
 */
package com.jl.transient1;

import java.io.Serializable;

/**
 * <p>
 * Title:
 * </p>
 * 
 * @author: jl
 * @date: 2018/08/23
 * @version: v1.0
 */
public class User implements Serializable{
	private static final long serialVersionUID = 8294180014912103005L;

	private String username;
	private transient String password;
	private static int age;

	public String getPasswd() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public static int getAge() {
		return age;
	}

	public static void setAge(int age) {
		User.age = age;
	}

}
