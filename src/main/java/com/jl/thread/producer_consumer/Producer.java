package com.jl.thread.producer_consumer;

/**
 * 
 * @Description: 生产者
 * @author jl
 * @date 2017年4月2日 上午12:13:05
 *
 */
public class Producer {

	private VariableBox box;

	public Producer(VariableBox box) {
		this.box = box;
	}

	/**
	 * 开始生产
	 */
	public void startProcude(Object lock) {
		try {
			synchronized (lock) {
				while (box.isFull()) {
					System.out.println("生产者 "+Thread.currentThread().getName()+" 进入等待");
					lock.wait();
				}
//				Thread.sleep(300);
				String product = System.currentTimeMillis() + "";
				box.addVariable(product);
				System.out.println("生产者 "+Thread.currentThread().getName()+"生产了物品：" + product + " size = " + box.size());
				lock.notifyAll();//希望只唤醒消费者进行消费
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
