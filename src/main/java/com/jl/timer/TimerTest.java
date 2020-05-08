/*
 * @(#)TImerTest.java  
 */
package com.jl.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/30
 * @version: v1.0
 */
public class TimerTest {
	
	public static void main(String[] args) {

		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("只运行一次的定时器");
			}
		}, 2000);
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("每隔1秒运行一次定时器，第一次运行需要等待2秒");
			}
		}, 2000,1000);
		
		
	}

}
