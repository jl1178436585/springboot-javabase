package com.jl.datastructures.recursion_linkedlist;

public class LinkedNode {

	public int val;
	public LinkedNode next;
	
	public LinkedNode(int val) {
		this.val = val;
	}
	
	public LinkedNode(int[] arry) {
		if(arry == null || arry.length <= 0) {
			throw new IllegalArgumentException("数组不能为空!");
		}
		
		//1.方法一
		/*LinkedNode head = new LinkedNode(arry[0]);
		LinkedNode temp = head; 
		for (int i = 1; i < arry.length; i++) {
			LinkedNode node = new LinkedNode(arry[i]);
			temp.next = node;
			temp = temp.next;
		}*/
		//2.方法二
		this.val = arry[0];
		LinkedNode curr = this;
		for (int i = 1; i < arry.length; i++) {
			curr.next = new LinkedNode(arry[i]);
			curr = curr.next;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		//打印当前节点到尾部节点
		LinkedNode head = this;
		while(head != null) {
			sb.append(head.val).append(">>>");
			head = head.next;
		}
		sb.append("null");
		return sb.toString();
	}
}
