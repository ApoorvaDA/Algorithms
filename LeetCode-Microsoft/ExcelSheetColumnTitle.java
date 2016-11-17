/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
public class Solution{
	public String convertToTitle(int n){
		StringBuilder s = new StringBuilder();
		int len=1;

		double temp = n;
		while(temp > 26){
			len++;
			temp=(temp-26)/26;
		}

		while(len > 0){
			int num = n%26;
			if (num == 0) {
				num = 26;
			}
			char ch = (char)('A'+num-1);
			s.append(ch);
			len--;
			n = (n-num)/26;
		}

		return s.reverse().toString();
	}

}
