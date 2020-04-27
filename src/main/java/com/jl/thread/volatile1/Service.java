package com.jl.thread.volatile1;

public class Service {

	private boolean isContinueRun = true;

	public boolean isContinueRun() {
		return isContinueRun;
	}

	public void setContinueRun(boolean isContinueRun) {
		this.isContinueRun = isContinueRun;
	}

	public void run(){
		while(isContinueRun){
			System.out.println();
		}
		System.out.println("停止运行了！");
	}
	
	public void stopRun(){
		this.isContinueRun = false;
	}
	
}
