/*
 * @(#)PersonComparable.java  
 */
package com.jl.sort;

import java.util.Comparator;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/07/22
 * @version: v1.0
 */
public class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getAge()-o2.getAge();
	}


}
