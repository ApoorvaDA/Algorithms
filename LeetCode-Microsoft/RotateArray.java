/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        for(int j=0; j<k; j++){    
            int temp = nums[nums.length - 1];
            for(int i=nums.length-1; i>0; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
        }    
    }
}

/*
There are 4 ways to solve this problem
	#1 Brute force
	#2 Using Extra Array
	#3 Using Cyclic replacements
	#4 Using Reverse
*/