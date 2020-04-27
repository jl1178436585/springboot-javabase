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
public class HeapSort2 {
	
	public static void main(String[] args) {
//		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25,53, 51 };
		Integer data[] = {49, 38, 65, 97, 76, 13, 27, 49, 78};
		heapSort(data);
		System.out.println(Arrays.toString(data));
		
//		MaxHeap<Integer> heap = new MaxHeap(data);
//		System.out.println(heap.toString());
	}


	public static void heapSort(Integer[] arr) {
		for (int i = getParentIndex(arr.length - 1); i >= 0; i--) {
			siftDown(arr, i);
//			swap(arr, 0, i);
		}
	}
	
	/**
	 * 下沉调整
	 * @param k
	 */
	private static void siftDown(Integer[] data,int k) {
		while(getLeftChildIndex(k) < data.length) {
			//i肯定有左孩子
			int biggerIndex = getLeftChildIndex(k);
			//有又孩子并且又孩子的值大于左孩子的值
			if(biggerIndex + 1 < data.length && data[biggerIndex + 1]>data[biggerIndex]) {
				biggerIndex = getRightChildIndex(k);
			}
			//此时data[j]是leftChild和RightChild中最大的值
			if(data[k] > data[biggerIndex]) {
				break;
			}else {
				swap(data,k, biggerIndex);
				k = biggerIndex;
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
	
	private static void swap(Integer[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
