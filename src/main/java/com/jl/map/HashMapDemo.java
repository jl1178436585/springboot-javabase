/*
 * @(#)HashSetDemo.java  
 */
package com.jl.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *<p>
 *	hashCode相等，equals不相等
 *</p>
 * @author: jl
 * @date: 2018/07/01
 * @version: v1.0
 */
public class HashMapDemo {


	public static void main(String[] args) {

		Key k1 = new Key("A");
		Key k2 = new Key("B");
		Key k3 = new Key("C");
		Key k4 = new Key("D");
		Key k5 = new Key("E");
		Key k6 = new Key("F");
		Key k7 = new Key("G");
		Key k8 = new Key("H");
		Key k9 = new Key("I");
		Key k10 = new Key("J");
		Key k11 = new Key("K");
		
		System.out.println("----------------");
		Map<Key,String> map = new HashMap<>();
		map.put(k1,"a");
		map.put(k2,"a");
		map.put(k3,"a");
		map.put(k4,"a");
		map.put(k5,"a");
		map.put(k6,"a");
		map.put(k7,"a");
		map.put(k8,"a");
		map.put(k9,"a");
		map.put(k10,"a");
		map.put(k11,"a");
		System.out.println(map.size());
		map.get(k5);
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
