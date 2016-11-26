/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?
*/

public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] count = new int[n+1];
        
        for(int i=0; i<n+1; i++){
            count[i] = 0;
        }
        
        for(int i=0; i<n; i++){
            count[nums[i]]++;
        }
        
        for(int i=0; i<n+1; i++){
            if(count[i]==0){
                return i;
            }
        }
        return -1;
    }
}