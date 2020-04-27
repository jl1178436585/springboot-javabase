/*
 * @(#)LinkedListSet.java  
 */
package com.jl.datastructures.set;

import com.jl.datastructures.linkedlist.LinkedList;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/22
 * @version: v1.0
 */
public class LinkedListSet<E> implements Set<E>{

	private LinkedList<E> list ;
	
	public LinkedListSet() {
		list = new LinkedList();
	}

	@Override
	public void add(E e) {
		//需要判重：LinkedList可以包含重复元素
		if(!list.contains(e)) {
			list.addFirst(e);
		}
		
	}

	@Override
	public void remove(E e) {
		list.removeElement(e);
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
