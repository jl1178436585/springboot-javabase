/*
 * @(#)ClassMethodTest.java  
 */
package com.jl.class1;


import com.jl.bean.Person;
import com.jl.bean.Student;
import org.junit.Test;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/10
 * @version: v1.0
 */
public class ClassMethodTest {

	
	/**
	 * a.isAssignableFrom(b): a是b的父类或者接口
	 * 
	 */
	@Test
	public void test1() {
		
		System.out.println(Person.class.isAssignableFrom(Person.class));//true
		System.out.println(Person.class.isAssignableFrom(Student.class));//true
		System.out.println(Student.class.isAssignableFrom(Person.class));//false
		System.out.println(Student.class.isAssignableFrom(Student.class));//true

		
		
		
	}
	
}
