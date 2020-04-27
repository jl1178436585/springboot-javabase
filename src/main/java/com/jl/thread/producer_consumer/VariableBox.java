package com.jl.thread.producer_consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description: 存放生产者生产的物品
 * @author jl
 * @date 2017年4月2日 上午12:14:26 
 *
 */
public class VariableBox {

	private List<String> variables;
	
	public VariableBox() {
		variables = new ArrayList<String>();
	}
	
	/**
	 * 存储物品
	 * @param s
	 */
	public void addVariable(String s){
		variables.add(s);
	}
	
	/**
	 * 消费物品
	 */
	public String subtract(){
		return variables.remove(0);
	}
		
	public boolean isEmpty() {
		return variables.isEmpty();
	}
	
	/**
	 * 物品超过十个表示已经满了，最大容纳十个
	 * @return
	 */
	public boolean isFull() {
		return variables.size() >= 5;
	}

	public int size() {
		return variables.size();
	}
	
}
