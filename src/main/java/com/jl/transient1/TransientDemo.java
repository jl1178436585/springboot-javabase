/*
 * @(#)TransientDemo.java  
 */
package com.jl.transient1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * <p>
 * Title:
 * </p>
 * 
 * @author: jl
 * @date: 2018/08/23
 * @version: v1.0
 */
public class TransientDemo {

	public static void main(String[] args) {
		User user = new User();
		user.setUserName("Alexia");
		user.setPassword("123456");
		user.setAge(21);

		System.out.println("read before Serializable: ");
		System.out.println("username: " + user.getUsername());
		System.out.println("age: " + user.getAge());
		System.out.println("password: " + user.getPasswd());

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:\\test\\learn\\user.txt"));
			os.writeObject(user); // 将User对象写进文件
			os.close();

			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:\\\\test\\\\learn\\\\user.txt"));
			user = (User) is.readObject(); // 从流中读取User的数据
			is.close();

			System.out.println("\n read after Serializable: ");
			System.out.println("username: " + user.getUsername());
			System.out.println("age: " + user.getAge());
			System.err.println("password: " + user.getPasswd());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
