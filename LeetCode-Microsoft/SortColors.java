/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

/*
Approach:
Uses Counting sort, but writes to the same array instead of a different array
*/

public class Solution{
	public void sortColors(int[] nums){
		int[] countArr = new int[3];
		// initialize array to 0
		for (int i=0;i<3 ;i++) {
			countArr[i] = 0;
		}
		//Populate count array with count from input array
		for (int i=0;i<nums.length ;i++) {
			countArr[nums[i]]+=1;
		}

		int j=0;
		for (int i=0;i<nums.length ;i++ ) {
			while (countArr[j] == 0) {
				j+=1;
			}
			if (countArr[j]>0) {
				countArr[j]-=1;
			}
			nums[i]=j;
		}
	}
}