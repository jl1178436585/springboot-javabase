package com.jl.datastructures.recursion_linkedlist;

/**
 * 递归删除链表中的元素
 * 
 * @author jl
 *
 */
public class ResursionDeleteLinekList {

	/**
	 * 链表可以想象成一个head节点后面跟了一个更小的链表，以此类推直到最后一个节点
	 * 
	 * 递归删除头结点是head的链表：递归到链表尾部，从尾部开始删除，最后返回head
	 * @param head
	 * @param value
	 * @return
	 */
	public static LinkedNode removeElements(LinkedNode head, int value) {
		if(head == null) {
			return null;
		}
		head.next = removeElements(head.next, value);
		if(head.val == value) {
			return head.next;
		}else {
			return head;
		}
	}
	
	public static void main(String[] args) {

		int[] nums = {5,8,6,3,4,5,6,};
		LinkedNode head = new LinkedNode(nums);
		System.out.println(head);
//		System.out.println(head.next);
		
		LinkedNode removeElement = removeElements(head, 6);
		System.out.println(removeElement);
	
	}
	
}
