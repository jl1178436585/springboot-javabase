package com.jl.thread.producer_consumer;

public class Test {


	public static void main(String[] args) {
		new Test().test1();
		
	}
	
	

	/**
	 * 消费者 Thread-2 进入等待
	生产者 Thread-1生产了物品：1491142011459 size = 1
	生产者 Thread-1生产了物品：1491142011760 size = 2
	生产者 Thread-1生产了物品：1491142012060 size = 3
	生产者 Thread-1生产了物品：1491142012361 size = 4
	生产者 Thread-1生产了物品：1491142012663 size = 5
	生产者 Thread-1 进入等待
	消费者 Thread-3--消费了1491142011459 size = 4
	消费者 Thread-3--消费了1491142011760 size = 3
	生产者 Thread-0生产了物品：1491142013564 size = 4
	生产者 Thread-0生产了物品：1491142013864 size = 5     ---消费的同时会生产物品

生产者 Thread-0 进入等待
	 * @param args
	 */
	@org.junit.Test
	public void test1(){

		Object lock = new Object();
		VariableBox box = new VariableBox();
		
		ProducerThread pThread1 = new ProducerThread(lock,box);
		ProducerThread pThread2 = new ProducerThread(lock,box);
		
		ConsumerThread cThread1 = new ConsumerThread(lock,box);
		ConsumerThread cThread2 = new ConsumerThread(lock,box);
		
		pThread1.start();
		pThread2.start();
		
		cThread1.start();
		cThread2.start();
		
	
	}
	
}
