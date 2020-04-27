/*
 * @(#)AVLMap.java  
 */
package com.jl.datastructures.map;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/07/27
 * @version: v1.0
 */

import com.jl.datastructures.tree.avl.AVLTree;

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V>{
	
	private AVLTree<K, V> avl;
	
	public AVLMap() {
		this.avl = new AVLTree<K, V>();
	}

	@Override
	public boolean put(K key, V value) {
		try {
			avl.set(key, value);			
		} catch (Exception e) {
			avl.add(key, value);
		}
		return true;
	}

	@Override
	public V remove(K key) {
		return avl.remove(key);
	}

	@Override
	public V get(K key) {
		return avl.get(key);
	}

	@Override
	public int getSize() {
		return avl.getSize();
	}

	@Override
	public boolean contains(K key) {
		return avl.contains(key);
	}

	@Override
	public boolean isEmpty() {
		return avl.isEmpty();
	}

}
