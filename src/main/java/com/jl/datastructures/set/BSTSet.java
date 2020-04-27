/*
 * @(#)BSTSet.java  
 */
package com.jl.datastructures.set;

import java.util.Comparator;

import com.jl.datastructures.tree.bst.BSTTree;

/**
 *<p>BST不包含重复元素，所以用BST实现Set</p>
 * @author: jl
 * @date: 2018/06/09
 * @version: v1.0
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{
	
	private BSTTree<E> bst;
	
	public BSTSet() {
		bst = new BSTTree<>();
	}

	@Override
	public void add(E e) {
		bst.add(e);
	}

	@Override
	public void remove(E e) {
		bst.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}

	@Override
	public int getSize() {
		return bst.getSize();
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}

}
