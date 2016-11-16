/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

*/

/*
Definition of a Singly Linked List
public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){ val = x;}

}
*/

public class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		return addTwoNumbersWithCarry(l1,l2,0);
	}

	public ListNode addTwoNumbersWithCarry(ListNode l1, ListNode l2, int carry){
		if(l1 == null && l2 == null){
			if(carry != 0){
				return new ListNode(carry);
			} else {
				return null;
			}
		} else {
			int sum=0;
			if (l1 != null) {
				sum+=l1.val;
				l1=l1.next;
			}

			if (l2 != null) {
				sum+=l2.val;
				l2 = l2.next;
			}

			if (carry != 0) {
				sum+=carry;
			}

			ListNode result = new ListNode(sum % 10);
			int c = sum/10;
			result.next = addTwoNumbersWithCarry(l1,l2,c);
			return result;
		}

	}

}