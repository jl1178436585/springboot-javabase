/*
 * @(#)BinarySearch.java  
 */
package com.jl.algorithm;

/**
 * <p>
 * 折半查找的先决条件是查找表中的数据元素必须有序
 *
 * 折半查找法的优点是比较次数少，查找速度快，平均性能好;
 * 其缺点是要求待查表为有序表，且插入删除困难。
 * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 * </p>
 * 
 * @author: jl
 * @date: 2018/07/29
 * @version: v1.0
 */
public class BinarySearch {
	/**
	 * 二分查找算法
	 * 
	 * @param srcArray
	 *            有序数组
	 * @param key
	 *            查找元素
	 * @return key的数组下标，没找到返回-1
	 */
	public static void main(String[] args) {
		int srcArray[] = { 3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101 };
		int key = 28;
		System.out.println(binSearch(srcArray, 0, srcArray.length - 1, key));
		System.out.println(binSearch(srcArray, key));
	}

	// 二分查找递归实现
	public static int binSearch(int srcArray[], int start, int end, int key) {
		int mid = (end - start) / 2 + start;
		if (srcArray[mid] == key) {
			return mid;
		}
		if (start >= end) {
			return -1;
		} else if (key > srcArray[mid]) {
			return binSearch(srcArray, mid + 1, end, key);
		} else if (key < srcArray[mid]) {
			return binSearch(srcArray, start, mid - 1, key);
		}
		return -1;
	}

	// 二分查找普通循环实现
	public static int binSearch(int srcArray[], int key) {
	/*	int mid = srcArray.length / 2;
		if (key == srcArray[mid]) {
			return mid;
		}*/

		int start = 0;
		int end = srcArray.length - 1;
		while (start <= end) {
			int mid = (end - start) / 2 + start;
			if (key < srcArray[mid]) {
				end = mid - 1;
			} else if (key > srcArray[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
