/*
 * @(#)HeapSort.java  
 */
package com.jl.algorithm;

import java.util.Arrays;

/**
 * <p>
 * 堆排序(Heapsort)是指利用堆积树（堆）这种数据结构所设计的一种排序算法，它是选择排序的一种。
 * 	可以利用数组的特点快速定位指定索引的元素。
 * 	堆分为大根堆和小根堆，是完全二叉树。
 * </p>
 * 
 * @author: jl
 * @date: 2018/08/04
 * @version: v1.0
 */
public class HeapSort {
	
	public static void main(String[] args) {
//		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25,53, 51 };
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78};
		heapSort(a);
	}

	public static void heapSort(int[] a) {
		int length = a.length;
		for (int i = 0; i < length - 1; i++) {//循环建堆
			buildMaxHeap(a, length - 1 - i);
			// 交换堆顶和最后一个元素
			swap(a, 0, length - 1 - i);
			System.out.println(Arrays.toString(a));
		}
	}

	// 对data数组从0到lastIndex建大顶堆
	private static void buildMaxHeap(int[] data, int lastIndex) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = getParentIndex(lastIndex); i >= 0; i--) {
			int k = i;
			while (getLeftChildIndex(k) <= lastIndex) {// 如果当前k节点的子节点存在
				int biggerIndex = getLeftChildIndex(k);
				if (biggerIndex < lastIndex) {
					if (data[biggerIndex] < data[biggerIndex + 1]) {// 若果右子节点的值较大
						biggerIndex++;// biggerIndex总是记录较大子节点的索引
					}
				}
				if (data[k] < data[biggerIndex]) {//如果k节点的值小于其较大的子节点的值
					swap(data, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
	
	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
	 * @param index：从0开始
	 * @return parent(i) = (i - 1) / 2
	 */
	public static int getParentIndex(int index) {
		if(index == 0) {
			throw new IllegalArgumentException("索引为0 的没有父索引");
		}
		return (index -1) / 2; 
	}
	

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
	 * @param index：从0开始
	 * @return 
	 */
	public static int getLeftChildIndex(int index) {
		return index * 2 + 1; 
	}
	

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
	 * @param index：从0开始
	 */
	public static int getRightChildIndex(int index) {
		return index *2 + 2; 
	}
	
	private static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
