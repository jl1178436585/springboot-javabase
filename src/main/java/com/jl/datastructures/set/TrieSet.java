/*
 * @(#)TrieSet.java  
 */
package com.jl.datastructures.set;

import com.jl.datastructures.trie.Trie;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/07/14
 * @version: v1.0
 */
public class TrieSet implements Set<String>{
	
	private Trie trie;
	
	public TrieSet() {
		trie = new Trie();
	}

	@Override
	public void add(String e) {
		trie.add(e);
	}

	@Override
	public void remove(String e) {
	}

	@Override
	public boolean contains(String e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
