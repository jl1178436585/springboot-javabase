package com.jl.datastructures.stack;

import com.jl.datastructures.array.Array;

/**
 * 用动态数组(可以自动扩容)实现的栈
 * 
 * @author jl
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

	private Array<E> array;
	
	public ArrayStack(int capacity) {
		array = new Array<E>(capacity);
	}
	
	public ArrayStack() {
		array = new Array<E>();
	}

	@Override
	public int getSize() {
		return array.getSize();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	public int getCapacity() {
		return array.getCapacity();
	}
	
	@Override
	public void push(E e) {
		array.addLast(e);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public E peek() {
		return array.getLast();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("stack : 【");
		for (int i = 0; i < array.getSize(); i++) {
			sb.append(array.get(i));
			if(i != array.getSize() - 1) {
				sb.append(",");
			}
		}
		sb.append("] top");//top表示栈顶
		return sb.toString(); 
	}
}
