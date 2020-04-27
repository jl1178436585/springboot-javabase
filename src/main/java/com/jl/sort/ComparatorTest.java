/*
 * @(#)ComparatorTest.java  
 */
package com.jl.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 * 用 Comparator 是策略模式（strategy design pattern），就是不改变对象自身，而用一个策略对象（strategy
 * object）来改变它的行为。
 * 
 * </p>
 * 
 * @author: jl
 * @date: 2018/07/22
 * @version: v1.0
 */
public class ComparatorTest {

	public static void main(String[] args) {
		// 产生一个20个随机整数的数组（有正有负）
		Random rnd = new Random();
		Integer[] integers = new Integer[20];
		for (int i = 0; i < integers.length; i++) {
			integers[i] = new Integer(rnd.nextInt(100) * (rnd.nextBoolean() ? 1 : -1));
		}
			
		System.out.println("排序之前：");
		System.out.println(Arrays.asList(integers));
		
		System.out.println("用Integer内置方法排序：");
		Arrays.sort(integers);
		System.out.println(Arrays.asList(integers));

		System.out.println("用MyComparator排序：");
		Arrays.sort(integers, new MyComparator());
		System.out.println(Arrays.asList(integers));
	}

}
