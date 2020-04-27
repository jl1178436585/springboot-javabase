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
				System.out.println("定时器");
			}
		}, 2000);
		
		
	}

}
