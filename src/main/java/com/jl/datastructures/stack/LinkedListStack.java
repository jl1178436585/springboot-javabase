package com.jl.datastructures.stack;

import com.jl.datastructures.linkedlist.LinkedList;

/**
 * 使用链表实现栈
 * 
 * @author jl
 * @param <E>
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E>{

	private LinkedList<E> data;
	
	public LinkedListStack() {
		data = new LinkedList<>();
	}
	
	
	@Override
	public int getSize() {
		return data.getSize();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public void push(E e) {
		data.addFirst(e);		
	}

	@Override
	public E pop() {
		return data.removeFirst();
	}

	@Override
	public E peek() {
		return data.getFirst();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("LinkedListStack: top :");
		sb.append(data);
		return sb.toString();
		
	}
	
	public static void main(String[] args) {

		LinkedListStack<String> stack = new LinkedListStack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(String.valueOf(i+1));
			System.out.println(stack);
		}
		
		
		String pop = stack.pop();//出栈
		System.out.println("出栈元素：" + pop);
		System.out.println(stack);
		
	
	}
}
