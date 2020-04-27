/*
 * @(#)mAIN.java  
 */
package com.jl.datastructures.map;

import java.util.ArrayList;

import com.jl.datastructures.tree.avl.FileOperation;

/**
 * <p>
 * Title:
 * </p>
 * 
 * @author: jl
 * @date: 2018/07/27
 * @version: v1.0
 */
public class Main {
	private static double testMap(Map<String, Integer> map, String filename) {

		long startTime = System.nanoTime();

		System.out.println(filename);
		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile(filename, words)) {
			System.out.println("单词总数: " + words.size());

			for (String word : words) {
				if (map.contains(word))
					map.put(word, map.get(word) + 1);
				else
					map.put(word, 1);
			}

			System.out.println("不同单词总数: " + map.getSize());
			System.out.println("pride出现的次数: " + map.get("pride"));
			System.out.println("prejudice出现的次数: " + map.get("prejudice"));
		}

		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}

	public static void main(String[] args) {

		String filename = "D:\\repst\\eclipse_repo\\javaBase\\src\\com\\jl\\datastructures\\tree\\pride-and-prejudice.txt";

		BSTMap<String, Integer> bstMap = new BSTMap<>();
		double time1 = testMap(bstMap, filename);
		System.out.println("BST Map: " + time1 + " s");

		System.out.println();

		
		LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
		double time2 = testMap(linkedListMap, filename);
		System.out.println("Linked List Map: " + time2 + " s");

		System.out.println();

		AVLMap<String, Integer> avlMap = new AVLMap<>();
		double time3 = testMap(avlMap, filename);
		System.out.println("AVL Map: " + time3 + " s");
	}
}
