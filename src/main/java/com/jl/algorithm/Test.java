/*
 * @(#)Test.java  
 */
package com.jl.algorithm;

import java.util.Arrays;

/**
 * <p>
 * Title:
 * </p>
 * 
 * @author: jl
 * @date: 2018/07/31
 * @version: v1.0
 */
public class Test {

	public static void main(String[] args) {

		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78};
//		for (int i = 0; i < a.length; i++)
//			System.out.println(a[i]);
		
		heapSort(a);
		System.out.println(Arrays.toString(a));
		
	}
	
	private static void heapSort(int[] data) {
		for(int i = getParent(data.length - 1); i>= 0; i--) {
			siftDown(data, i);
//			swap(data, 0, i);
		}
	}

	private static void siftDown(int[] data,int k) {
		while(getLeft(k) < data.length) {
			int biggerIndex = getLeft(k);
			if(biggerIndex + 1 < data.length && data[biggerIndex + 1] >data[biggerIndex]) {
				biggerIndex  = getRight(k);
			}
			if(data[k] > data[biggerIndex]) {
				break;
			}else {
				swap(data, biggerIndex, k);
				k = biggerIndex;
			}
		}
	}

	
	
	public static int getParent(int i) {
		return( i -1)/2;
	}
	
	public static int getLeft(int i) {
		return 2 * i + 1;
	}
	public static int getRight(int i) {
		return 2 * i + 2;
	}
	
	private static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}



	
}
