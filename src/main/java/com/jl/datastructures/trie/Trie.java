/*
 * @(#)Trie.java  
 */
package com.jl.datastructures.trie;
/**
 *<p>
 *  Trie:一般存储的是字符串
 *</p>
 * @author: jl
 * @date: 2018/07/03
 * @version: v1.0
 */

import java.util.Set;
import java.util.TreeMap;

public class Trie {
	
	private class Node{
		private boolean isWord;//是否是一个单词的结尾
		
		private TreeMap<Character, Node> next;
		
		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<>();
		}

		public Node() {
			this(false);
		}
		
		public boolean isWord() {
			return isWord;
		}

		public void setIsWord(boolean isWord) {
			this.isWord = isWord;
		}
		
	}
	
	private Node root;
	private int size;
	
	public Trie() {
		root = new Node();
		size = 0;
	}
	
	public void add(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(curr.next.get(c)==null) {
				curr.next.put(c, new Node());
			}
			curr = curr.next.get(c);
		}
		
		if(!curr.isWord) {//防止多次添加同一个，size统计错误
			curr.setIsWord(true);
			size++;
		}
	}

	/**
	 * 获取Trie中存储的单词数量
	 * @return
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * 查询单词Word是否在Trie中
	 * @param word
	 * @return
	 */
	public boolean contains(String word) {
		if(word == null || word.length() <= 0) {
			return false;
		}
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node node = curr.next.get(c);
			if(node == null) {
				return false;
			}else {
				curr = node;
			}
		}
		
		//不能直接返回true,还需要判断单词word是否都在Trie中
		return curr.isWord;
	}
	
	/**
	 * 查询Trie中存储的单词是否有以prefix其前缀的单词
	 * @param prefix
	 * @return
	 */
	public boolean isPrefix(String prefix) {
		Node curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			Node node = curr.next.get(c);
			if(node != null) {//存在该字符
				curr = node;
			}else {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 搜索单词word:可以用.来匹配任意一个字符
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		return match(root, word, 0);
	}
	
	public boolean match(Node node,String word, int index) {
		if(index == word.length()-1) {
			return node.isWord;
		}
		
		char c = word.charAt(index);
		if(c == '.') {
			Set<Character> keySet = node.next.keySet();
			for (Character nextChar : keySet) {
				if(match(node.next.get(nextChar), word, index+1)) {
					return true;
				}
			}
			return false;//所有的都匹配失败才返回false
		}else {
			Node nextNode = node.next.get(c);
			if(nextNode == null) {
				return false;
			}
			return match(nextNode, word, index+1);
		}
		
	}
	
	
	
}
