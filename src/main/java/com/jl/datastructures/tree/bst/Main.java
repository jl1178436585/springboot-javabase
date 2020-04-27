/*
 * @(#)Main.java  
 */
package com.jl.datastructures.tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/05/27
 * @version: v1.0
 */
public class Main {

	public static void main(String[] args) {
		BSTTree<Integer> bst = new BSTTree<>();
		/**
		 * 			5
		 * 		  /   \	
		 * 		 3     6 
		 * 	   /  \     \
		 *    2	   4	 8   
		 */
		int[] arr = new int[]{5,3,6,8,4,2};
//		int[] arr = new int[]{20,14,25,13,12,16,15,23,40,30,50,49,47,60,48};
		for (int i : arr) {
			bst.add(i);
		}
		
		System.out.println("元素个数：" + bst.getSize());
		
		System.out.println("递归前序遍历：");
		bst.preOrder();//5,3,2,4,6,8
		
		System.out.println("非递归前序遍历：");
		bst.preOrderNoRecursion();//5,3,2,4,6,8
		
		System.out.println("中序遍历：");
		bst.inOrder();//2,3,4,5,6,8
		
		System.out.println("后序遍历：");
		bst.postOrder();//2,4,3,8,6,5
		
		/************** 广度优先遍历 ************/
		System.out.println("层序遍历：");
		bst.levelOrder();//5,3,6,2,4,8
		
		System.out.println("=================");
		System.out.println(bst);
		
		int depath = bst.getDepath();
		System.out.println(depath);
	}
	
	@Test
	public void testRemoveMinMax() {
		BSTTree<Integer> bst = new BSTTree<>();
		Random random = new Random();
		
		int n = 1000;
		for (int i = 0; i < n; i++) {
			bst.add(random.nextInt(10000));
		}
		
		List<Integer> nums = new ArrayList<>();
		while(!bst.isEmpty()) {
			nums.add(bst.removeMin());
		}
		//nums应该是从小到大排序
		System.out.println(nums);
		for (int i = 1; i < nums.size(); i++) {
			if(nums.get(i-1) > nums.get(i)) {
				throw new IllegalArgumentException("排序有误！");
			}
		}
		
		System.out.println("remove正确");
		
		
	}
	
}
