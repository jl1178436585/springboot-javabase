package com.jl.datastructures.queue;

import java.util.Random;

/**
 * 测试动态数组队列和循环队列的性能
 * 
 * @author jl
 *
 */
public class Main {

	public static double testQueue(Queue<String> q,int count) {
		
		long startTime = System.nanoTime();//纳秒
		
		Random random = new Random(); 
		
		for (int i = 0; i < count; i++) {
			q.enqueue(String.valueOf(random.nextInt()));
		}
		
		for (int i = 0; i < count; i++) {
			q.dequeue();
		}
		
		long endTime = System.nanoTime();//纳秒
		return ((endTime - startTime) / 1000000000.0);
	}

	public static void main(String[] args) {
		int capacity = 100000;
		Queue<String> arrayQueue = new DynamicArrayQueue<>();
		double testQueue = testQueue(arrayQueue, capacity);
		System.out.println("动态数组队列耗时：" + testQueue);
		
		Queue<String> loopQueue = new LoopArrayQueue<>();
		double testQueue2 = testQueue(loopQueue, capacity);
		System.out.println("循环数组队列耗时：" + testQueue2);
		
		Queue<String> linkedListQueue = new LinkedListQueue<>();
		double testQueue3 = testQueue(linkedListQueue, capacity);
		System.out.println("链表队列耗时：" + testQueue3);
	}
	
}
