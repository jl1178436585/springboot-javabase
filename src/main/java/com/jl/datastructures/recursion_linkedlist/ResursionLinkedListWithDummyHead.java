package com.jl.datastructures.recursion_linkedlist;

/**
 * leetCode链表问题：带有虚拟头结点
 * @author jl
 *
 */
public class ResursionLinkedListWithDummyHead {

	/**
	 * 删除head指向的链表中的元素val,
	 * @param head
	 * @param val
	 * @return： 返回head
	 */
	public static LinkedNode removeElement(LinkedNode head,int val) {
		LinkedNode dummyHead = new LinkedNode(-1);
		dummyHead.next = head;
		
		LinkedNode prev = dummyHead;
		while(prev.next != null) {
			if(prev.next.val == val) {
				LinkedNode resNode = prev.next;
				prev.next = resNode.next;
				resNode.next = null;//垃圾回收，断开与原来链表的关系
			}else {
				prev = prev.next;
			}
		}
//		return head;
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,6,3,4,5,6,};
		LinkedNode head = new LinkedNode(nums);
		System.out.println(head);
//		System.out.println(head.next);
		
		LinkedNode removeElement = removeElement(head, 1);
		System.out.println(removeElement);
		
	}
	
}
