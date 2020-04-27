/*
 * @(#)QuickSort.java  
 */
package com.jl.algorithm;

import java.util.Arrays;

/**
 * <p>
 * 快速排序简称快排，是一种比较快的排序，适合基本无序的数据，为什么这么说呢？下面我说下快排的思路：
 * 
 * </p>
 * 
 * @author: jl
 * @date: 2018/07/29
 * @version: v1.0
 */
public class QuickSort {

	public static void main(String[] args) {
		  int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			quickSort(list, low, middle - 1); // 对低字表进行递归排序
			quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}
	
	private static int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}



}
