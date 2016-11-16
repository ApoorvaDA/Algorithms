public class Solution{
	public int findKthLargest(int[] nums, int k){
		if(nums.length < k){
			return 0;
		}

		Queue<Integer> pq = new PriorityQueue<Integer>(k);
		for (int i=0; i< nums.length ; i++ ) {
			if (i<k) {
				pq.add(nums[i]);
			} else {
				if (nums[i] > pq.peek()) {
					pq.poll();
					pq.add(nums[i]);
				}
			}
		}
		return pq.peek();
	}
}