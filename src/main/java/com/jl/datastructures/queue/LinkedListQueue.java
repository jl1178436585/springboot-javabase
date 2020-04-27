package com.jl.datastructures.queue;

/**
 * 用链表实现队列：用改进的链表，也就是增加一个变量用来记住链表的尾部，由于尾部删除元素还是O(n),所以尾部用来新增，head用来删除<br>
 * 也就是说head作为队首，tail作为队尾
 * 
 * @author jl
 *
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>{
	
	private class Node{//链表节点
		public E e;
		public Node next;
		
		public Node(E e,Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this(e,null);
		}
		
		@Override
		public String toString() {
			return e.toString();
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * 入队:tail端入队
	 */
	@Override
	public void enqueue(E e) {
		
		if(tail == null) {//此时head也是null
			tail = new Node(e);
			head = tail;
		}else {
			tail.next = new Node(e); 
			tail = tail.next;
		}
		size++;
		
	}

	@Override
	public E dequeue() {
		if(head == null) {
			throw new IllegalArgumentException("队列不能为空！");
		}
		Node headE = head;
		head = head.next;
		headE.next = null;//不要忘记这个，利于垃圾回收
		size--;
		if(head == null) {//当head为空的时候，说明队列没有元素了，此时tail也应该为null
			tail = null;
		}
		return headE.e;
	}

	@Override
	public E getFront() {
		return head.e;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("链表队列： front [");
		Node curr = head;
		while(curr != null) {
			sb.append(curr.e).append(">>>");
			curr = curr.next;
		}
		sb.append("NULL] tail");
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedListQueue<String> queue = new LinkedListQueue<>();
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
