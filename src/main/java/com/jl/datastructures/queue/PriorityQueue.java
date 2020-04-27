/*
 * @(#)PriorityQueue.java  
 */
package com.jl.datastructures.queue;
/**
 *<p>
 *	基于堆的优先队列
 *</p>
 * @author: jl
 * @date: 2018/08/04
 * @version: v1.0
 */

import com.jl.datastructures.heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E>{
	
	private MaxHeap<E> maxHeap;

	public PriorityQueue() {
		this.maxHeap = new MaxHeap<E>();
	}
	
	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E dequeue() {
		return maxHeap.extractMax();
	}

	@Override
	public E getFront() {
		return maxHeap.findMax();
	}

	@Override
	public int getSize() {
		return maxHeap.getSize();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

}
