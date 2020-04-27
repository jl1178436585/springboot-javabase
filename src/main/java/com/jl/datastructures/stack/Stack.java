package com.jl.datastructures.stack;

/**
 * 栈接口:与具体实现无关的，只能操作栈顶元素，中间的元素不可见
 * 	1.可以用动态数组来实现，这时候动态数组MyArrayGeneric就会有自己的getCapacity()方法
 * 
 * @author jl
 *
 * @param <E>
 */
public interface Stack<E> {

	int getSize();
	
	public boolean isEmpty();
	
	public void push(E e);
	
	/**
	 * 取出栈顶元素
	 * @return
	 */
	public E pop();

	/**
	 * 查询栈顶元素
	 * @return
	 */
	public E peek();
}
