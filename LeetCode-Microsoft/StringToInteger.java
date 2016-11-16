/*
Implement atoi to convert a string to an integer.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. 
If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class Solution{
	public int atoi(String str){
		long res = 0;
		boolean neg = false;
		String s = str.trim();
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if ((c=='-' || c=='+') && i==0) neg = c=='-';
			else if (c>='0' && c<='9') res = res*10 + c - '0';
			else break;
			if (i>8 && !neg && res>Integer.MAX_VALUE) {
			 	return Integer.MAX_VALUE;
			}
			if (i>8 && neg && -1*res<Integer.MIN_VALUE) {
			 	return Integer.MIN_VALUE;
			}
			return (int)(neg?-1*res:res); 
		}
	}
}