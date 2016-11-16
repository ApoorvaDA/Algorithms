/*
A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.

Return a deep copy of the list.

*/
/*
Definition of a singly-linked list with a Random Pointer
class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x){label = x};
}

*/


public class Solution{
	if (head == null) {
		return null;
	}

	Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();

	RandomListNode node = head;
	while(node != null){
		map.put(node, new RandomListNode(node.label));
		node = node.next;
	}

	node = head;
	while(node != null){
		map.get(node).next = map.get(node.next);
		map.get(node).random = map.get(node.random);
		node = node.next;
	}
	return map.get(head);

}