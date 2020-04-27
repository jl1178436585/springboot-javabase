/*
 * @(#)ClassLoader1.java  
 */
package com.jl.vm.classloader;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/24
 * @version: v1.0
 */

class CL{
	
	static {
		System.out.println("Class CL...static block");
	}
	
}


public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {
		//获取系统类加载器
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		//sun.misc.Launcher$AppClassLoader@18b4aac2
		System.out.println(systemClassLoader.toString());
		
		//从硬盘加载到内存:调用ClassLoader的loadClass()方法并不是对类的主动使用，不会导致类的初始化
		Class<?> loadClass = systemClassLoader.loadClass("com.jl.vm.classloader.CL");
		
		System.out.println("---------------");
		
		Class<?> forName = Class.forName("com.jl.vm.classloader.CL");
	
		String property = System.getProperty("sun.boot.class.path");
		System.out.println(property);
		
		String javaClassPath = System.getProperty("java.class.path");
		System.out.println(javaClassPath);
		
	}
	
	
}
