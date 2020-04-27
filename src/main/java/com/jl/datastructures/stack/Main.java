package com.jl.datastructures.stack;

import java.util.Random;

/**
 * 测试链表栈和数组栈的效率： 效率只供参考
 * 
 * @author jl
 *
 */
public class Main {

	public static double testStack(Stack<String> stack,int count) {
		
		long startTime = System.nanoTime();//纳秒
		
		Random random = new Random(); 
		
		for (int i = 0; i < count; i++) {
			stack.push(String.valueOf(random.nextInt()));
		}
		
		for (int i = 0; i < count; i++) {
			stack.pop();
		}
		
		long endTime = System.nanoTime();//纳秒
		return ((endTime - startTime) / 1000000000.0);
	}

	public static void main(String[] args) {
		int capacity = 1000000;
		Stack<String> arrayStack = new ArrayStack<>();
		double testQueue = testStack(arrayStack, capacity);
		System.out.println("动态数组栈耗时：" + testQueue);
		
		Stack<String> loopStack = new LinkedListStack<>();
		double testQueue2 = testStack(loopStack, capacity);
		System.out.println("链表栈耗时：" + testQueue2);
	}
	
}
