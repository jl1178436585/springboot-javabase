/*
 * @(#)BSTMap.java  
 */
package com.jl.datastructures.map;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/30
 * @version: v1.0
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K, V>{
	
	private class Node{
		public K key;
		public V value;
		public Node left;
		public Node right;
		
		public Node(K key,V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	
	private int size;

	public BSTMap() {
		root = null;
		size = 0;
	}
	
	@Override
	public boolean put(K key, V value) {
		
		Node node = putkeyValue(root, key,value);
		return true;
	}

	private Node putkeyValue(Node node,K key,V value) {
		if(node == null) {
			Node newNode = new Node(key, value);
			size++;
			return newNode;
		}
		
		if(node.key.compareTo(key) < 0) {
			node.left = putkeyValue(node.left, key, value);
		}else if(node.key.compareTo(key) > 0) {
			node.right = putkeyValue(node.right, key, value);
		}else {//相等
			node.value = value;
		}
		
		return node;
		
	}
	
	
	@Override
	public V remove(K key) {
		
		Node node = getNode(root, key);
		if(node != null) {
			root = removeNode(root,key);
			return node.value;
		}
		
		return null;
	}
	
	/**
	 * 返回删除节点之后的二分搜索树的根节点
	 * @param node
	 * @param key
	 * @return
	 */
	private Node removeNode(Node node,K key) {
		if(node == null) {
			return null;
		}
		if(key.compareTo(node.key) < 0) {
			node.left = removeNode(node.left, key);
			return node;
		}else if(key.compareTo(node.key) > 0) {
			node.right = removeNode(node.right, key);
			return node;
		}else {
			if(node.left == null) {//直接把右子树挂过去
				Node right = node.right;
				node.right = null;
				size--;
				return right;
			}
			
			if(node.right == null) {//选出左子树中最大的节点
				Node left = node.left;
				node.left = null;
				size--;
				return left;
			}
			//待删除的节点左右子树均不为空的情况：找到比待删除节点大的最小的节点，
			//(我们可以选择左儿子中的最大元素或者右儿子中的最小元素放到待删除节点的位置，就可以保证结构的不变)
			//即待删除节点右子树的最小节点，用这个节点顶替待删除节点的位置
			Node successor = getMinNode(node.right);
			Node deleteMinNode = removeMinNode(node.right);
			successor.left = node.left;
			successor.right = deleteMinNode;
			
			node.left = node.right = null;//与二分搜索树脱离关系
			return successor;
		}
		
		
	}
	
	private Node getMinNode(Node node) {
		if(node.left == null) {
			return node;
		}
		return getMinNode(node.left);
	}
	
	/**
	 * 返回删除后的二分搜索树的根节点
	 * @param node
	 * @return
	 */
	private Node removeMinNode(Node node) {
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMinNode(node.left);
		return node;
	}

	@Override
	public V get(K key) {
		Node node = getNode(root, key);
		if(node ==null) {
			return null;
		}
		return node.value;
	}
	
	private Node getNode(Node node,K key) {
		if(node == null) {
			return null;
		}
		if(key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		}else if(key.compareTo(node.key) > 0) {
			return getNode(node.right, key);
		}else {
			return node;
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean contains(K key) {
		Node node = getNode(root, key);
		return node != null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
