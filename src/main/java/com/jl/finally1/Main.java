/*
 * @(#)Main.java  
 */
package com.jl.finally1;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/08/11
 * @version: v1.0
 */
public class Main {

	public static void main(String[] args) {
		try {
			FinallyDemo demo = new FinallyDemo();
			demo.say();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			System.out.println("main-----finally--------");
		}
	}
}
