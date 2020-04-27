/*
 * @(#)MyComparator.java  
 */
package com.jl.sort;

import java.util.Comparator;

/**
 * <p>
 * Title:
 * </p>
 * 
 * @author: jl
 * @date: 2018/07/22
 * @version: v1.0
 */
public class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		int v1 = Math.abs(o1.intValue());
		int v2 = Math.abs(o2.intValue());
		return v1 > v2 ? 1 : (v1 == v2 ? 0 : -1);
	}

}
