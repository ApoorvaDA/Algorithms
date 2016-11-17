/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
/*
Definition of singly-linked list
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}
*/

public class Solution{
	public boolean hasCycle(ListNode head){
		ListNode next = head;
		while(next != null){
			if(next.next == next)
				return true;
			ListNode temp = next.next;
			next.next = next;
			next = temp;
		}
		return false;
	}
}