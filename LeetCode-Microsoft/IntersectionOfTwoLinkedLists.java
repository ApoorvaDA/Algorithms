/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:

- If the two linked lists have no intersection at all, return null.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.
*/

/*
Inter­sec­tion point means end of one linked list is linked with some node in another linked list 
and it forms a Y shape.

Approach:
- Find the length of both the linked lists say : a_len and b_len
- Find the len­Diff = (a_len ~ b_len)
- Tra­verse the longer linked list by lenDiff
- Now tra­verse both the lists at the same time
- Check whether nodes are same, if yes then we have found the inter­sec­tion point
- If we reach the end of the link lists then there is no inter­sec­tion point.
*/

/*
Definition of ListNode
public class ListNode{
	int val;
	ListNode left;
	ListNode right;
	ListNode(int x){
		val = x;
	}
}
*/

public class Solution{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		//Base condition if either lists are null
		if (headA==null || headB==null) {
			return null;
		}

		//Find the lengths of both the lists
		int len1=0, len2=0;
		ListNode p1=headA, p2=headB;

		while(p1 != null){
			p1=p1.next;
			len1++;
		}

		while(p2 != null){
			p2=p2.next;
			len2++;
		}

		p1=headA;
		p2=headB;
		int diff = 0;
		if (len1 > len2) {
			diff = len1 - len2;
			int i=0;
			while(i<diff){
				p1 = p1.next;
				i++;
			}
		} else {
			diff = len2 - len1;
			int i=0;
			while (i<diff) {
				p2 = p2.next;
				i++;
			}
		}

		while(p1 != null && p2 != null){
			if (p1.val==p2.val) {
				return p1;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return null;
	}

}