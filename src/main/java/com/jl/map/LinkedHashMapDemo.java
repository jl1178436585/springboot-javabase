package com.jl.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedHashMapDemo {

	public static void main(String[] args) {

		/**
		 * LinkedHashMap测试
		 */
		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("a1", "1111");
		linkedHashMap.put("b2", "2222");
		linkedHashMap.put("a11", "1111");
		linkedHashMap.put("c3", "3333");
		Set<Entry<String, String>> entrySet = linkedHashMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			System.out.println(key);
		}
		
		System.out.println("---------------------");
		
		/**
		 * HashMap
		 */
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("a1", "1111");
		hashMap.put("b2", "2222");
		hashMap.put("a11", "1111");
		hashMap.put("c3", "3333");
		Set<Entry<String, String>> entrySet1 = hashMap.entrySet();
		for (Entry<String, String> entry : entrySet1) {
			String key = entry.getKey();
			System.out.println(key);
		}
	}
}
