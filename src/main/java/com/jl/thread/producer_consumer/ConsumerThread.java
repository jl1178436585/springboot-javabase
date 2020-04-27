package com.jl.thread.producer_consumer;

/**
 * 
 * @Description: 消费者线程
 * @author jl
 * @date 2017年4月2日 上午12:13:05
 *
 */
public class ConsumerThread extends Thread {

	private Object lock;
	private Consumer c;
	
	public ConsumerThread(Object lock,VariableBox box) {
		this.c = new Consumer(box) ;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		while(true){
			c.startConsume(lock);
		}
			
	}
	

}
