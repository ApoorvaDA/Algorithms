/*
Given a binary tree, return the level order traversal of its nodes' values. 
(ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
/*
Definition of a Binary Tree node.
private class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){val = x;}
}
*/

public class Solution{
	public List<List<Integer>> levelOrder (TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()){
			int n = q.size();
			List<Integer> temp = new ArrayList<Integer>();
			for (int i=0;i<n;i++) {
				TreeNode node = q.poll();
				temp.add(node.val);
				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}
			result.add(temp);
		}
		return result;
	}
}