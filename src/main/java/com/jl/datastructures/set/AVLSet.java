/*
 * @(#)AVLSet.java  
 */
package com.jl.datastructures.set;

import com.jl.datastructures.tree.avl.AVLTree;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/07/27
 * @version: v1.0
 */
public class AVLSet<E extends Comparable<E>> implements Set<E>{
	
	private AVLTree<E, Object> avl;
	
	private static final Object PRESENT = new Object();
	
	public AVLSet() {
		this.avl = new AVLTree<E, Object>();
	}

	@Override
	public void add(E e) {
		avl.add(e, PRESENT);
	}

	@Override
	public void remove(E e) {
		avl.remove(e);		
	}

	@Override
	public boolean contains(E e) {
		return avl.contains(e);
	}

	@Override
	public int getSize() {
		return avl.getSize();
	}

	@Override
	public boolean isEmpty() {
		return avl.isEmpty();
	}

}
