/*
 * @(#)Main.java  
 */
package com.jl.datastructures.heap;

import java.util.Random;

import org.junit.Test;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/08/03
 * @version: v1.0
 */
public class Main {


	
	private static double testHeap(Integer[] testdata,boolean isHeapify) {
		long start = System.currentTimeMillis();
		MaxHeap<Integer> maxHeap = null;
		if(isHeapify) {
			maxHeap = new MaxHeap<>(testdata);
		}else {
			maxHeap = new MaxHeap<>();
			for (Integer integer : testdata) {
				maxHeap.add(integer);
			}
		}
		
		int[] arr = new int[testdata.length];
        for(int i = 0 ; i < testdata.length ; i ++)
            arr[i] = maxHeap.extractMax();

        //arr里的是从大到小排序
        for(int i = 1 ; i < testdata.length ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");

		
		long end = System.currentTimeMillis();
		
		return (end - start) / 1000.0 ; 
	}
	
	@Test
	public void testArrTransferMaxHeap() {
		int n = 1000000;//100万
		Random random = new Random();
		Integer[] testdata = new Integer[n];
		for (int i = 0; i < n; i++) {
			int nextInt = random.nextInt(Integer.MAX_VALUE);
			testdata[i] = nextInt;
		}
		
		double time1 = testHeap(testdata, true);
		System.out.println("使用heapify把数组转成最大堆耗时:" + time1);
		double time2 = testHeap(testdata, false);
		System.out.println("不使用heapify把数组转成最大堆耗时:" + time2);
	}
	
	
    public static void main(String[] args) {

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0 ; i < n ; i ++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++)
            arr[i] = maxHeap.extractMax();

        //arr里的是从大到小排序
        for(int i = 1 ; i < n ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");
    }



}
