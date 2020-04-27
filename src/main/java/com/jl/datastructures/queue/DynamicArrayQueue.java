package com.jl.datastructures.queue;

import com.jl.datastructures.array.Array;

/**
 * 使用动态数组实现队列:出队的时候，后续元素要依次往前移动一个位置，所以出队的时间复杂度是O(n)
 * 
 * @author jl
 *
 * @param <E>
 */
public class DynamicArrayQueue<E> implements Queue<E>{

	private Array<E> array;
	
	public DynamicArrayQueue(int capacity) {
		array = new Array<E>(capacity);
	}
	
	public DynamicArrayQueue() {
		array = new Array<E>();
	}

	/**
	 * 进队
	 */
	@Override
	public void enqueue(E e) {
		array.addLast(e);
	}

	@Override
	public E dequeue() {
		return array.removeFirst();
	}

	@Override
	public E getFront() {
		return array.getFirst();
	}
	
	/**
	 * 因为是使用数组实现的队列，所以会存在数组容量
	 * @return
	 */
	public int getCapacity() {
		return array.getCapacity();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("queue : font[");
		for (int i = 0; i < array.getSize(); i++) {
			sb.append(array.get(i));
			if(i != array.getSize() - 1) {
				sb.append(",");
			}
		}
		sb.append("] tail");
		return sb.toString(); 
	}
	
	public static void main(String[] args) {
		DynamicArrayQueue<String> queue = new DynamicArrayQueue<>(10);
		for (int i = 0; i < 10; i++) {
			queue.enqueue(String.valueOf(i));
			System.out.println(queue);
			if(i % 3 == 2) {
				queue.dequeue();
				System.out.println(queue);
			}
		}
	}
}
