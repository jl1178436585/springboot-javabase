/*
 * @(#)HeapOOM.java  
 */
package com.jl.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *<p>
 *	堆内存溢出异常测试
 *	VM args: -Xmx20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=D:\test\jvm
 *</p>
 * @author: jl
 * @date: 2018/08/19
 * @version: v1.0
 */
public class HeapOOM {

	static class OOMObj{
	}
	
	public static void main(String[] args) {
		List<OOMObj> list = new ArrayList<>();
		while(true) {
			list.add(new OOMObj());
		}
	}
	
	/**
	 *  java.lang.OutOfMemoryError: Java heap space
		Dumping heap to java_pid10444.hprof ...
		Heap dump file created [28146485 bytes in 0.080 secs]
		Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
			at java.util.Arrays.copyOf(Arrays.java:3210)
			at java.util.Arrays.copyOf(Arrays.java:3181)
			at java.util.ArrayList.grow(ArrayList.java:265)
			at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:239)
			at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:231)
			at java.util.ArrayList.add(ArrayList.java:462)
			at com.jl.jvm.oom.HeapOOM.main(HeapOOM.java:26)

	 * 
	 * 
	 */
	
}
