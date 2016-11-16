/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

public class Solution{
	public int maxSubArray(int[] nums){
		int res = Integer.MIN_VALUE, sum = 0;
		for (int i=0; i<nums.length ;i++ ) {
			sum+=nums[i];
			res = Math.max(res,sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return res;
	}
}

/* Also try using Divide and Conquer Approach*/