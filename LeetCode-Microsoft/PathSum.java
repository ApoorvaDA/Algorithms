/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

/*
Definition of Binary Tree Class

public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
*/

public class Solution{
	public boolean PathSum(TreeNode root, int sum){
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> values = new LinkedList<Integer>();

		if (root == null) {
			return false;
		}
		nodes.add(root);
		values.add(root.val);

		while(!nodes.isEmpty()){
			TreeNode currentNode = nodes.poll();
			int sumVal = values.poll();

			if (currentNode.left == null && currentNode.right == null && sumVal == sum) {
				return true;
			}

			if (currentNode.left != null) {
				nodes.add(currentNode.left);
				values.add(sumVal+currentNode.left.val);
			}

			if (currentNode.right != null) {
				nodes.add(currentNode.right);
				values.add(sumVal+currentNode.right.val);
			}

		}
		return false;
	}

}
