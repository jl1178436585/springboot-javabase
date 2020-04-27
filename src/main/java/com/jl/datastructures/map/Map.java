/*
 * @(#)Map.java  
 */
package com.jl.datastructures.map;
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/30
 * @version: v1.0
 */
public interface Map<K,V> {

	public boolean put(K key, V value);
	
	public V remove(K key);
	
	public V get(K key);

	public int getSize();
	
	public boolean contains(K key);
	
	public boolean isEmpty();
	
}
