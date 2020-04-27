/*
 * @(#)RutimeConstantPoolOOM.java  
 */
package com.jl.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *<p>
 *	运行时常量池异常OOM:
 *	 
 * 限制方法区大小(1.6是用永久代来实现的方法区)
 * Vm args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * 在JDK1.6：false false
 * 在JDK1.7：true false
 * 
 *</p>
 * @author: jl
 * @date: 2018/08/19
 * @version: v1.0
 */
public class RutimeConstantPoolOOM2 {

	public static void main(String[] args) {
		String str1 = new StringBuffer("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuffer("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
	
}
