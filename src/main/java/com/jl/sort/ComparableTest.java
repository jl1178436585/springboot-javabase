/*
 * @(#)ComparableTest.java  
 */
package com.jl.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/07/22
 * @version: v1.0
 */
public class ComparableTest {

	public static void main(String[] args) {
		
		PersonObj p1 = new PersonObj("A");
		PersonObj p2 = new PersonObj("B");
		System.out.println(p1.compareTo(p2));
		
		
//		或者
		StudentComparator studentComparator = new StudentComparator();
		Student s1 = new Student(11);
		Student s2 = new Student(12);
		int compare = studentComparator.compare(s1, s2);
		System.out.println(compare);
	}
	
}
