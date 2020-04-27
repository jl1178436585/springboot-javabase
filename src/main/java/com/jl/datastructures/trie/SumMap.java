/*
 * @(#)SumMap.java  
 */
package com.jl.datastructures.trie;

import java.util.TreeMap;

/**
 *<p>
 *	利用Trie实现每一个单词对应一个权重
 *</p>
 * @author: jl
 * @date: 2018/07/15
 * @version: v1.0
 */
public class SumMap {

	private class Node{
		private double value;
		private TreeMap<Character,Node> next;
		
		public Node(double value) {
			this.value = value;
		}
		
		public Node() {
		}
	}
	
	private Node root;
	
	public SumMap() {
		root = new Node();
	}
	
	/**
	 * 
	 * @param word
	 * @param val:单词word的权重
	 */
	public void add(String word,int val) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(curr.next.get(c) == null) {
				curr.next.put(c, new Node());
			}
			curr = curr.next.get(c);
		}
		
		curr.value = val;
	}
	
	/**
	 * 求以prefix为前缀的单词的权重和
	 * @param prefix
	 * @return
	 */
	public double sum(String prefix) {
		Node curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char charAt = prefix.charAt(i);
			if(curr.next.get(charAt) == null) {
				return 0;
			}
			curr = curr.next.get(charAt);
		}
		
		return sum(curr);
	}

	private double sum(Node node) {
		double sumValue = node.value;
		for (Character c : node.next.keySet()) {
			sumValue = sumValue + sum(node.next.get(c));
		}
		
		return sumValue;
	}
	
}
