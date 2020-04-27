package com.jl.thread.producer_consumer;

/**
 * 
 * @Description: 生产者
 * @author jl
 * @date 2017年4月2日 上午12:13:05
 *
 */
public class ProducerThread extends Thread {

	private Object lock;
	private Producer p;
	
	public ProducerThread(Object lock,VariableBox box) {
		this.p = new Producer(box);
		this.lock = lock;
	}
	
	@Override
	public void run() {
		while(true){
			p.startProcude(lock);
		}
	}
	

}
