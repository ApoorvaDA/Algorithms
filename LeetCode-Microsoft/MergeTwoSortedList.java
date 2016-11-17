/*
Merge Two Sorted Lists   
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode out = new ListNode(0);
		ListNode prev = out.next;

		while(l1 != null && l2 != null){
			if (l1.val > l2.val) {
				prev.next = l2;
				l2 = l2.next;
			} else {
				prev.next = l1;
				l1 = l1.next;
			}
			prev = prev.next;
		}
		if (l2 == null) {
			prev.next = l1;
		}
		if (l1 == null) {
			prev.next = l2;
		}
		return out.next;
	}
}