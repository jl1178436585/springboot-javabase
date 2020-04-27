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
 * 在JDK1.6：OutOfMemoryError:PermGen sapce
 * 在JDK1.7：将会一直循环下去
 * 
 *</p>
 * @author: jl
 * @date: 2018/08/19
 * @version: v1.0
 */
public class RutimeConstantPoolOOM {

	public static void main(String[] args) {
		//是用list保持着常量池的应用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<>();
		//10MB的PermSize在integer范围内足够产生OOM了
		int i = 0;
		while(true) {
			String intern = String.valueOf(i++).intern();
			list.add(intern);
			System.out.println(intern);
		}
		
		
	}
	
}
