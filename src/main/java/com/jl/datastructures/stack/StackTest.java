package com.jl.datastructures.stack;

import org.junit.Test;

public class StackTest {

	@Test
	public void test1() {
		ArrayStack<String> stack = new ArrayStack<>();
		for (int i = 0; i < 5; i++) {
			stack.push(String.valueOf(i+1));
			System.out.println(stack);
		}
		
		
		String pop = stack.pop();//出栈
		System.out.println("出栈元素：" + pop);
		System.out.println(stack);
		
	}
	
}
