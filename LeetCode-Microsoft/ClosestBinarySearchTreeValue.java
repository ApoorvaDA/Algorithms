/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

/*
Definition of a Binary Tree Node.
public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}
*/


public class Solution{
	public int closestValue(TreeNode root, double target){
		double min_difference = Double.MAX_VALUE;
		int output = root.val;

		while (root != null) {
		    if(target == root.val) {
		        output = root.val;
		        return output;
		    } else if (target > root.val) {
				double diff = Math.abs(target - root.val);
				if (diff < min_difference) {
					min_difference = diff;
					output = root.val;
				}
				root = root.right;
			}	else {
				double diff = Math.abs(root.val - target);
				if (diff < min_difference) {
					min_difference = diff;
					output = root.val;
				}
				root = root.left;
			}	
		}
		return output;
	}
}