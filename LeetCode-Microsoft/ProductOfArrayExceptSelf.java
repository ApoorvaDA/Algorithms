/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

Approach : 
Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. 
The product is left*right. We can get lefts and rights:

Numbers:     2    3    4     5
Lefts:            2  2*3 2*3*4
Rights:  3*4*5  4*5    5      
Let’s fill the empty with 1:

Numbers:     2    3    4     5
Lefts:       1    2  2*3 2*3*4
Rights:  3*4*5  4*5    5     1
*/

public class Solution{
	public int[] productExceptSelf(int[] nums){
		int n = nums.length;
		int[] output = new int[n];

		int left=1, right=1;

		for (int i=0; i<n-1 ;i++ ) {
			if (i>0) {
				left*=nums[i-1];	
			}
			output[i] = left;
		}

		for (int i=n-1; i>=0 ;i--) {
			if (i<n-1) {
				right*=nums[i+1];
			}
			output[i]*=right;
		}

		return output;
	}
}