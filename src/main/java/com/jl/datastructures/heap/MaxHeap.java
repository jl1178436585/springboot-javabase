/*
 * @(#)MaxHeap.java  
 */
package com.jl.datastructures.heap;
/**
 *<p>最大堆:</p>
 * @author: jl
 * @date: 2018/08/03
 * @version: v1.0
 */

import java.util.Arrays;

import org.junit.experimental.theories.FromDataPoints;

import com.jl.datastructures.array.Array;

public class MaxHeap<E extends Comparable<E>> {
	
	private Array<E> data ;
	
	public MaxHeap(int capacity) {
		data = new Array<E>(capacity);
	}
	
	public MaxHeap() {
		data = new Array<E>();
	}

	/**
	 * headIfy: 将任意数组转换成堆的形状:O(n)
	 * 
	 * @param arr
	 */
	public MaxHeap(E[] arr) {
		data = new Array<E>(arr);
		for (int i = getParentIndex(arr.length - 1); i >= 0; i--) {
			siftDown(i);
		}
	}
	
	/**
	 * 将任意数组转换成堆的形状:O(n)
	 * @param arr
	 */
	public static void headIfy(int[] arr) {
	}
	
	public int getSize() {
		return data.getSize();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
	 * @param index：从0开始
	 * @return parent(i) = (i - 1) / 2
	 */
	public int getParentIndex(int index) {
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
	public int getLeftChildIndex(int index) {
		return index * 2 + 1; 
	}
	

	/**
	 * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
	 * @param index：从0开始
	 */
	public int getRightChildIndex(int index) {
		return index *2 + 2; 
	}
	
	/**
	 * 向堆中添加元素:时间复杂度是O(logn)
	 * @param e
	 */
	public void add(E e) {
		data.addLast(e);
		siftUp(data.getSize()-1);
	}
	
	/**
	 * 上浮调整
	 * 
	 * @param i
	 */
	private void siftUp(int i) {
		while( i > 0 && data.get(getParentIndex(i)).compareTo(data.get(i)) < 0) {
			data.swap(i, getParentIndex(i));
			i =  getParentIndex(i);
		}
	}
	
	/**
	 * 看堆中最大的元素
	 * @return
	 */
	public E findMax() {
		if(data.getSize() == 0) {
			System.out.println("堆中元素个数为0");
			return null;
		}
		
		return data.get(0);
	}
	
	
	/**
	 * 取出堆中最大的元素:时间复杂度是O(logn)
	 * @return
	 */
	public E extractMax() {
		E max = findMax();
		//第0个和最后一个交换位置
		data.swap(0, data.getSize()-1);
		data.removeLast();	
		siftDown(0);//logN
		return max;
	}

	/**
	 * 下沉调整
	 * @param k
	 */
	private void siftDown(int k) {
		while(getLeftChildIndex(k) < data.getSize()) {
			//i肯定有左孩子
			int biggerIndex = getLeftChildIndex(k);
			//有又孩子并且又孩子的值大于左孩子的值
			if(biggerIndex + 1 < data.getSize() && data.get(biggerIndex + 1).compareTo(data.get(biggerIndex)) > 0) {
				biggerIndex = getRightChildIndex(k);
			}
			//此时data[j]是leftChild和RightChild中最大的值
			if(data.get(k).compareTo(data.get(biggerIndex)) > 0) {
				break;
			}else {
				data.swap(k, biggerIndex);
				k = biggerIndex;
			}
		}
	}
	
	/**
	 * 取出堆中的最大元素，并且替换为元素e:只进行了一次logN级别的操作
	 * 或者先extractMax(),再addFirst()，那就是两次LogN操作了
	 * @param e
	 */
	public E replace(E e) {
		E max = findMax();
		data.set(0, e);
		siftDown(0);//logN
		return max;
		
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < data.getSize(); i++) {
			sb.append(data.get(i)).append(",");
		}
		return sb.toString();
	}

}
