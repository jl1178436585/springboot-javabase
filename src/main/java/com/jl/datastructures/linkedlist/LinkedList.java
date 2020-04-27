package com.jl.datastructures.linkedlist;

/**
 * <p>前面的动态数组com.jl.datastructures.array.MyDynamicGenericArray<E>本质是靠resize来实现的，底层依托的是静态数组</p>
 * 	
 * 基于上面的动态数组实现的栈和队列也是这样的，本质还是靠resize()扩容来实现动态数组,这三种数据结构目前都是线性的<br>
 * 
 * 但是链表是非线性的结构，靠着指针来实现
 * 
 * 
 * 此类是用带虚拟头节点实现的链表
 * 
 * head:指向链表头部元素所在位置
 * 
 * @author jl
 *
 */
public class LinkedList<E> {
	   
	public class Node{
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
	
	private int size;
	/**
	 * 虚拟头节点
	 */
	private Node dummyHead;
	
	public LinkedList() {
		dummyHead = new Node(null);
		dummyHead.next = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 往链表头部添加元素
	 * @param e
	 */
	public void addFirst(E e) {
		add(0, e);
	}
	
	/**
	 * 链表的操作实际上很少用到在指定索引添加元素，此处只是便于理解链表，练习使用
	 * 
	 * @param index
	 * @param e
	 */
	public void add(int index,E e) {
		if(index <0 || index > size) {
			throw new IllegalArgumentException("索引不能小于0或者大于元素总数");
		}

		//查找带插入节点的前一个节点
		Node prev = dummyHead;
		for(int i = 0; i < index; i++) {
			prev = prev.next;
		}
		Node node = new Node(e);
		node.next = prev.next;
		prev.next = node;
		//一定不要忘记size++
		size++;
	
	}
	
	/**
	 * 往链表尾部添加元素
	 * @param e
	 */
	public void addLast(E e){
		add(size,e);
	}
	
	
	/**
	 * 此处只是便于理解链表，练习使用
	 * 
	 * @param index
	 * @param e
	 * @return 
	 */
	public E get(int index) {
		if(index <0 || index > size) {
			throw new IllegalArgumentException("索引不能小于0或者大于元素总数");
		}
		
		Node currNode = dummyHead.next;
		for(int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		return currNode.e;
	
	}

	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size-1);
	}
	
	public void set(int index, E e) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("索引不能小于0或者大于元素总数");
		}
		Node currNode = dummyHead.next;
		for(int i = 0; i < index; i++) {
			currNode = currNode.next;
		}
		currNode.e = e;
	}
	
	public boolean contains(E e) {
		Node currNode = dummyHead.next;
		for(int i = 0; i < size; i++) {
			if(currNode.e.equals(e)) {
				return true;
			}
			currNode = currNode.next;
		}
		
		return false;
	}
	
	public E remove(int index) {
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("索引不能小于0或者大于元素总数");
		}
		
		Node prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		
		Node result = prev.next;
		prev.next = result.next;
		
		result.next = null;
		size--;
		
		return result.e;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	/**
	 * 移除最后一个元素
	 * @return
	 */
	public E removeLast() {
		return remove(size-1);
	}
	
	public void removeElement(E e) {
		Node prev = dummyHead;
		while(prev.next != null) {
			if(prev.next.e.equals(e)) {
			  break;
			}
			prev = prev.next;
		}
		
		if(prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node curr = dummyHead.next;
		while (curr != null) {
			sb.append(curr.e).append(">>>");
			curr = curr.next;
		}
		sb.append("NULL");
		return sb.toString();
	}

}
