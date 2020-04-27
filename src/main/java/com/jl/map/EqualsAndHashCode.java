package com.jl.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:重写equals方法时，为什么要重写hashCode
 * @author jl
 * @date 2016年8月12日 下午10:32:53
 *
 */
public class EqualsAndHashCode {

	public static void main(String[] args) {
/*		Map<String, Value> map1 = new HashMap<String, Value>();
		String s1 = new String("key");
		String s2 = new String("key");
		Value value = new Value(2);
		map1.put(s1, value);
		System.out.println("s1.equals(s2):" + s1.equals(s2));
		System.out.println("map1.get(s1):" + map1.get(s1));
		System.out.println("map1.get(s2):" + map1.get(s2));*/

		Map<Key, Value> map2 = new HashMap<Key, Value>();
		Key k1 = new Key("A");
		Key k2 = new Key("A");
		Value value1 = new Value(2);
		map2.put(k1, value1);
//		map2.put(k2, value1);
		System.out.println("k1.equals(k2):" + k1.equals(k2));
		System.out.println("map2.get(k1):" + map2.get(k1));
		System.out.println("map2.get(k2):" + map2.get(k2));//Key是否重写了hashCode和equals
		
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
			return k.hashCode();
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
