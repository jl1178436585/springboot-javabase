package com.jl.datastructures.linkedlist;

/**
 * <p>前面的动态数组com.jl.datastructures.array.MyDynamicGenericArray<E>本质是靠resize来实现的，底层依托的是静态数组</p>
 * 	
 * 基于上面的动态数组实现的栈和队列也是这样的，本质还是靠resize()扩容来实现动态数组,这三种数据结构目前都是线性的<br>
 * 
 * 但是链表是非线性的结构，靠着指针来实现
 * 
 * 
 * 此类是用不带虚拟头节点实现的链表
 * 
 * head:指向链表头部元素所在位置
 * 
 * @author jl
 *
 */
public class LinkedListNoVirtualNode<E> {
	   
	private class Node{
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
	private int size;
	
	public LinkedListNoVirtualNode() {
		head = null;
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
		Node node = new Node(e);
		node.next = head;
		head = node;		
		size++;
		//等价于head = new Node(e,head);
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
		if(index == 0) {
			addFirst(e);
		}else{
			//查找带插入节点的前一个节点
			Node prev = head;
			for(int i = 0; i < index-1; i++) {
				prev = prev.next;
			}
			Node node = new Node(e);
			node.next = prev.next;
			prev.next = node;
			//一定不要忘记size++
			size++;
		}
	}
	
	/**
	 * 往链表尾部添加元素
	 * @param e
	 */
	public void addLast(E e){
		add(size,e);
	}
	
	
}
