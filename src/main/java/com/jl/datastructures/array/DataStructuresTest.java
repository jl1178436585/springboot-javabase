package com.jl.datastructures.array;

import org.junit.Test;

import com.jl.bean.Student;

/**
 * 数据结构测试类
 * @author jl
 *
 */
public class DataStructuresTest {

	public static void main(String[] args) {
		MyArray array = new MyArray(20);
		for(int i =0; i < 10; i++) {
			array.addLast(i);
		}
		System.out.println(array);
		
		array.add(1, 390);
		System.out.println(array);
		
		array.addFirst(100);
		System.out.println(array);
	}
	
	@Test
	public void testArrayGeneric() {
		Array<Student> array = new Array<Student>(20);
		System.out.println(array);
		array.addLast(new Student("a", 21));
		array.addLast(new Student("b", 22));
		array.addLast(new Student("c", 23));
		
		System.out.println(array);
	}
	
	/**
	 * 数组扩容测试
	 */
	@Test
	public void testArrayGenericResize() {
		Array<Student> array = new Array<Student>();
		System.out.println(array);
		for(int i = 0; i < 10; i++) {
			array.addLast(new Student("a", i));
		}
		System.out.println(array);
		array.add(1, new Student("李逍遥", 25));
		System.out.println(array);
		array.addFirst(new Student("李逍遥2", 26));
		System.out.println(array);
	}
}
