/*
 * @(#)Main.java  
 */
package com.jl.datastructures.tree.avl;

import java.util.ArrayList;
import java.util.Collections;

import com.jl.datastructures.tree.bst.BST;

public class Main {

	
	/**
	 *  Pride and Prejudice
	    Total words: 125901
		BST: 22.953202944 s
		AVL: 0.091357665 s
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Pride and Prejudice");

		ArrayList<String> words = new ArrayList<>();
		if (FileOperation.readFile("D:\\repst\\eclipse_repo\\javaBase\\src\\com\\jl\\datastructures\\tree\\pride-and-prejudice.txt", words)) {
			System.out.println("Total words: " + words.size());

			 Collections.sort(words);

			// Test BST
			long startTime = System.nanoTime();

			BST<String, Integer> bst = new BST<>();
			for (String word : words) {
				if (bst.contains(word))
					bst.set(word, bst.get(word) + 1);
				else
					bst.add(word, 1);
			}

			for (String word : words)
				bst.contains(word);

			long endTime = System.nanoTime();

			double time = (endTime - startTime) / 1000000000.0;
			System.out.println("BST: " + time + " s");

			// Test AVL Tree
			startTime = System.nanoTime();

			AVLTree<String, Integer> avl = new AVLTree<>();
			for (String word : words) {
				if (avl.contains(word))
					avl.set(word, avl.get(word) + 1);
				else
					avl.add(word, 1);
			}

			for (String word : words)
				avl.contains(word);

			endTime = System.nanoTime();

			time = (endTime - startTime) / 1000000000.0;
			System.out.println("AVL: " + time + " s");
			
			for (String word : words)
				avl.remove(word);
			
			System.out.println(avl.isBlanced());
		}

		System.out.println();
	}
}
