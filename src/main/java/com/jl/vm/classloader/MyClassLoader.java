/*
 * @(#)MyClassLoader.java  
 */
package com.jl.vm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *<p>
 *	测试参考 默认包下面的MyClassLoader.java
 *</p>
 * @author: jl
 * @date: 2018/06/25
 * @version: v1.0
 */
public class MyClassLoader extends ClassLoader{

	private String name;//类加载器的名称
	
	private String path= "d:\\" ;//加载类的路径
	
	private final String fileType = ".class"; //class文件的扩展名
	
	public MyClassLoader(String name) {
		super(); //让系统类加载器成为该类加载器的父加载器
		this.name = name;
	}
	
	public MyClassLoader(ClassLoader panrent,String name) {
		super(panrent); //让系统类加载器成为该类加载器的父加载器
		this.name = name;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = loadClassData(name);
		
		return this.defineClass(name,data, 0, data.length);
	}
	
	private byte[] loadClassData(String name) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		byte[] data = new byte[1024]; 
		try {
			this.name = this.name.replaceAll(".", "\\");
			in = new FileInputStream(new File(path + name + fileType));
			
			out = new ByteArrayOutputStream();
			int len = 0;
			while((len = in.read(data))!= -1) {
				out.write(data, 0, len);
			}
			
			data = out.toByteArray();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileType() {
		return fileType;
	}
	

	public static void main(String[] args) {
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("D:\\test\\loader1");
		
		MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
		loader2.setPath("D:\\test\\loader2");
		
		//父类加载器是根类加载器
		MyClassLoader loader3 = new MyClassLoader(null,"loader3");
		loader3.setPath("D:\\test\\loader3");
		
		test(loader2);
		test(loader3);
	}

	public static void test(ClassLoader classLoader) {
		try {
			Class<?> clazz = classLoader.loadClass("com.jl.vm.Sample");
			Object object = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
