/*
 * @(#)LinkedListHashMap.java  
 */
package com.jl.datastructures.map;

import java.util.HashMap;

/**
 *<p>
 *  无序的
 *</p>
 * @author: jl
 * @date: 2018/06/30
 * @version: v1.0
 */
public class LinkedListMap<K,V> implements Map<K,V>{
	
	public class Node{
		public K key;
		public V value;
		
		public Node next;
		
		public Node(K key,V value) {
			this(key,value,null);
		}
		
		public Node(K key,V value,Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public Node(K key) {
			this(key,null,null);
		}
		
		public Node() {
			this(null,null,null);
		}
		
		@Override
		public String toString() {
			return key.toString()+":" +value.toString();
		}
	}

	private Node dumyHeade;
	
	private int size;
	
	public LinkedListMap() {
		dumyHeade = new Node();
		size = 0;
	}
			
	
	@Override
	public boolean put(K key, V value) {
		Node node = getNode(key);
		if(node == null) {
			Node newNode = new Node(key,value,dumyHeade.next);//没有就添加到头部
			dumyHeade.next = newNode;
			size++;
		}else {
			node.value =value;
		}
		
		return true;
	}

	@Override
	public V remove(K key) {
		Node prev = dumyHeade;//前一个节点
		while (prev.next != null) {
			if(key.equals(prev.next.key)) {
				break;
			}
			prev = prev.next;
		}
		if(prev.next != null) {//待删除的节点正好是最后一个节点不需要处理
			Node deleteNode = prev.next;
			prev.next = deleteNode.next;
			deleteNode.next = null;
			size--;
			return deleteNode.value;
		}
		return null;
		
	}

	private Node getNode(K key) {

		Node node = dumyHeade.next;
		while (node != null) {
			if(node.key.equals(key)) {
				return node;
			}
			node = node.next;
		}
		return null;
	
	}
	
	@Override
	public V get(K key) {
		Node node = getNode(key);
		if(node != null) {
			return node.value;
		}
		return null;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean contains(K key) {
		Node node = getNode(key);
		return node != null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		java.util.Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		String remove = map.remove("11");
		System.out.println(remove);
		
	}
	
}
