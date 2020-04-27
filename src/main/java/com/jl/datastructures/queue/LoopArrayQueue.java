package com.jl.datastructures.queue;

import com.jl.datastructures.array.Array;

/**
 * 循环数组实现队列：front指向队首元素，tail指向下一个要插入的队尾元素位置   <br>
 * 队列为空：front == tail <br>
 * 队列满：(tail+1)%array.length == front,由此可以看出循环队列会浪费一个空间
 * 
 * 由于动态数组队列的出队操作是O(n),所以出现了循环队列	
 *	
 * @author jl
 *
 * @param <E>
 */
public class LoopArrayQueue<E> implements Queue<E>{

	private E[] array;
	private int front;//指向队首元素
	private int tail;//指向队尾元素位置
	private int size ;//元素个数
	
	/**
	 * 因为循环队列会浪费一个空间，所以实际创建的时候会对创建一个来保证容量是capacity
	 * @param capacity
	 */
	public LoopArrayQueue(int capacity) {
		array = (E[])new Object[capacity + 1];
		front = tail = 0;
		size = 0;
	}
	
	public LoopArrayQueue() {
		this(10);
	}
	
	/**
	 * 实际容量比length少一个空间
	 * @return
	 */
	public int getCapacity() {
		return this.array.length-1;
	}
	

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}
	
	/**
	 * 判断队列是否已经满了
	 * @return
	 */
	public boolean isFull() {
		return (tail+1)%this.array.length == front;
	}
	
	/**
	 * 扩容
	 * @param newCapacity
	 */
	public void resize(int newCapacity) {
		E[] newArray = (E[])new Object[newCapacity+1];
		//把元素放入新的数组中
		for(int i = 0; i < size; i++) {//不是小于array.length
			newArray[i] = this.array[(front+i) % this.array.length];
		}
		array = newArray;
		front = 0;
		tail = size;
	}
	
	/**
	 * 入队
	 */
	@Override
	public void enqueue(E e) {
		//1.如果队列已经满了，扩容到原来的2倍
		if(isFull()) {
			resize(getCapacity() * 2);
		}
		array[tail] = e;
		tail = (tail + 1) % array.length;
		size++;
	}

	/**
	 * 出队
	 */
	@Override
	public E dequeue() {
		//1.判断是否为空
		if(isEmpty()) {
			throw new IllegalArgumentException("队列为空！");
		}
		
		E frontE = array[front];
		array[front] = null;//便于垃圾回收
		front = (front+1)%this.array.length;
		size--;//一定不要忘记size减一
		
		//2.当实际元素个数小于容量的1/4的时候，进行缩容操作,缩容到原来的容量的一半
		if(size <= getCapacity() / 4 && this.getCapacity() / 2 != 0) {
			 resize(this.getCapacity() / 2);
		}
		
		return frontE;
	}

	@Override
	public E getFront() {
		//1.判断是否为空
		if(isEmpty()) {
			throw new IllegalArgumentException("队列为空！");
		}
		return this.array[front];
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("loop queue: size=%d, capacity=%d \n",size,this.getCapacity()));
//		sb.append("queue: size=" +size + " capacity=%d " + this.getCapacity()).append("\n");
		sb.append("font[");
		
		//此处的遍历和resize()中的遍历是两种方法
		for (int i = front; i!= tail; i = (i+1)%this.array.length) {
			sb.append(array[i]);
			if((i+1)%this.array.length != tail) {
				sb.append(",");
			}
		}
		sb.append("] tail \n\n");
		return sb.toString(); 
	}
	
	public static void main(String[] args) {
		LoopArrayQueue<String> queue = new LoopArrayQueue<>(10);
		for (int i = 0; i < 10; i++) {
			queue.enqueue(String.valueOf(i));
			System.out.println(queue);
			if(i % 3 == 2) {
				queue.dequeue();
				System.out.println(queue);
			}
		}
	}
	
}
