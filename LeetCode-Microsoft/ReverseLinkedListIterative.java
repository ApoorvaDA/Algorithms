/*
Definition for Singly-Linked list.
public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}
*/

public class Solution{

	public ListNode ReverseListNode(ListNode head){
		ListNode currNode, prevNode, nextNode;
		currNode = head;
		prevNode = null;
		nextNode = null;

		while(currNode != null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			currNode = nextNode;
			prevNode = currNode;
		}

		head = prevNode;
		return head;
	}
}