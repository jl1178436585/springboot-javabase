package com.jl.thread.producer_consumer;

/**
 * @Description: 消费者
 * @author jl
 * @date 2017年4月2日 下午8:56:01 
 *
 */
public class Consumer {

	private VariableBox box;
	public Consumer(VariableBox box){
		this.box = box;
	}
	

	/**
	 * 开始消费
	 */
	public void startConsume(Object lock){
		try {
			synchronized (lock) {
				while(box.isEmpty()){
					System.out.println("消费者 "+Thread.currentThread().getName()+" 进入等待");
					lock.wait();
				}
				
				
//				Thread.sleep(300);
				String product = box.subtract();
				System.out.println("消费者 "+Thread.currentThread().getName()+"--消费了" + product+ " size = " + box.size());
				lock.notifyAll();//
				
			}
		} catch (Exception e) {
			
		}
	}
	
}

