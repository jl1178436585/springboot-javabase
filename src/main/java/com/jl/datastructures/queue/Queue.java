package com.jl.datastructures.queue;

public interface Queue<E> {
	
	/**
	 * 进队
	 * @param e
	 */
	public void enqueue(E e);
	
	/**
	 * 出队
	 */
	public E dequeue();
	
	/**
	 * 查看队列头的元素
	 * @return
	 */
	public E getFront();
	
	public int getSize();
	
	public boolean isEmpty();

}
