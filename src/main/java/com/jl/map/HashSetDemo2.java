/*
 * @(#)HashSetDemo.java  
 */
package com.jl.map;

import java.util.HashSet;
import java.util.Set;

/**
 *<p>
 *	重写了equals，也重写了hashCode,保证equals相等的hashCode也相等
 *</p>
 * @author: jl
 * @date: 2018/07/01
 * @version: v1.0
 */
public class HashSetDemo2 {


	public static void main(String[] args) {

		Key k1 = new Key("A");
		Key k2 = new Key("A");
		
		System.out.println("----------------");
		Set<Key> set = new HashSet<>();
		set.add(k1);
		set.add(k2);
		System.out.println(set.size());
	}

	/**
	 * 键
	 * 
	 */
	static class Key {
		private String k;

		public Key(String key) {
			this.k = key;
		}

		@Override
		public boolean equals(Object obj) {
//			if (obj instanceof Key) {
//				Key key = (Key) obj;
//				return k.equals(key.k);
//			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return 2;
		}
	}

	/**
	 * 值
	 * 
	 */
	static class Value {
		private int v;

		public Value(int v) {
			this.v = v;
		}

		@Override
		public String toString() {
			return "类Value的值－－>" + v;
		}
	}


}
