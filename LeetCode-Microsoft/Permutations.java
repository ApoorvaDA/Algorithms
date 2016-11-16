/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Solution{
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> p = new ArrayList<List<Integer>>();

		List<Integer> n = new ArrayList<>();
		for (int i=0;i<nums.length ;i++ ) {
			n.add(nums[i]);
		}

		permute(n,p,new ArrayList<Integer>(),nums.length);
		return p;
	}

	public static void permute(List<Integer> l, List<List<Integer>> p, List<Integer> r, int len){
		if (r.size() == len) {
			p.add(new ArrayList<Integer>(r));
			return;
		}
		for (int j=0; j < l.size(); j++ ) {
			int n=l.get(j);
			l.remove(j);
			r.add(n);
			permute(l,p,r,len);
			r.remove(r.size()-1);
			l.add(j,n);
		}
	}

}