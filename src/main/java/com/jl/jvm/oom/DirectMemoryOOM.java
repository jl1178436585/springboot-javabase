/*
 * @(#)DirectMemoryOOM.java  
 */
package com.jl.jvm.oom;


import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * <p>
 * 	测试直接内存DirectMemory溢出：
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * 
 * </p>
 * 
 * @author: jl
 * @date: 2018/08/19
 * @version: v1.0
 */
public class DirectMemoryOOM {

	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while(true) {
			unsafe.allocateMemory(_1MB);
		}
	}
	
	/**
	 * 
	 * Exception in thread "main" java.lang.OutOfMemoryError
	at sun.misc.Unsafe.allocateMemory(Native Method)
	at com.jl.jvm.oom.DirectMemoryOOM.main(DirectMemoryOOM.java:31)

	 * 
	 */

}
