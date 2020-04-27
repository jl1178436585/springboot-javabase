package com.jl.thread.test;

import org.junit.Test;

public class ThreadTest {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
//				Thread.sleep(1000);
				System.out.println("runnable---run");
			}
		}) {
			public void run() {
				System.out.println("thread-----run");
			};
		}.start();
		
//		test1();
	}
	
	public static void test1(){
		Dog dog = new Dog();

		Thread1 thread1 = new Thread1(dog);
		Thread2 thread2 = new Thread2(dog);
		
		thread1.start();
		thread2.start();
	}
	
	public static void test2(){
		Dog dog = new Dog();
		Thread1 thread1 = new Thread1(dog);
		Thread1 thread11 = new Thread1(dog);
		thread1.start();
		thread11.start();
		
	}
	
	public void testThread(){
		Dog dog = new Dog();
		Thread1 thread1 = new Thread1(dog);
		thread1.start();
	}
}
