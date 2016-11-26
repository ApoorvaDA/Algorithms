/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

*/

public class Solution{
	public void reverseWords(char[] s){
		int len = s.length;
		int cur = 0, right;
		reverse(s,0,len-1);

		while(cur<len){
			right = cur;
			while (right<len && s[right]!=' ') {
				right++;
			}
			reverse(s, cur,right-1);
			cur = right + 1;
		}
	}

	public void reverse(char[] s, int left, int right){
		char c;
		while(left < right){
			c = s[left];
			s[left] = s[right];
			s[right] = c;
			left++;
			right--;
		}

	}

}

/*
Without using char[]
*/
public class Solution{
	public String reverseWords(String s){
		String[] splitted = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		int length = splitted.length;

		for (int i=length-1; i>=0 ;i++ ) {
			sb.append(splitted[i]+" ");
		}
		String reverse = sb.toString().trim();
		return reverse;
	}
}