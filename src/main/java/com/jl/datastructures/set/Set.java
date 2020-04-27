/*
 * @(#)MySet.java  
 */
package com.jl.datastructures.set;

/**
 * <p>
 * Title:
 * </p>
 * 
 * @author: jl
 * @date: 2018/06/09
 * @version: v1.0
 */
public interface Set<E> {

	void add(E e);

	void remove(E e);

	boolean contains(E e);

	int getSize();

	boolean isEmpty();

}
