package com.jl.datastructures.recursion_linkedlist;

/**
 * leetCode链表问题
 * @author jl
 *
 */
public class ResursionLinkedList {

	/**
	 * 删除head指向的链表中的元素val,
	 * @param head
	 * @param val
	 * @return： 返回head
	 */
	public LinkedNode removeElement(LinkedNode head,int val) {
		
		//1.删除head中可能是val的元素： 因为前面可能连着多个节点的值都是待删除的值，所以需要循环head
		while(head != null && head.val == val) {
			//删除head
			LinkedNode resultNode = head;
			head = head.next;
			resultNode.next = null;//垃圾回收，断开与原来链表的关系
		}
		if(head == null) {
			return null;//链表的元素全部都是val
		}
		
		//2.删除中间元素
		LinkedNode prev = head;
		while(prev.next != null) {
			if(prev.next.val == val) {
				LinkedNode resNode = prev.next;
				prev = resNode.next;
				resNode.next = null;//垃圾回收，断开与原来链表的关系
			}else {
				prev = prev.next;
			}
		}
		
		return head;
	}
	
}
