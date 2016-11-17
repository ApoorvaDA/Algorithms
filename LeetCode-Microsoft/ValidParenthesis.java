/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

import java.util.Stack;

public class Solution{
	public boolean isValid(String s){
		Stack<Character> s = new Stack<Character>();
		for (char c: s.toCharArray() ) {
			if (c=='('||c=='{'||c=='[') {
				stack.push(c);
			} else {
				if (stack.empty()) {
					return false;
				}
				Character p = stack.pop();
				char v = p.charValue();

				if ((v=='('&&c!=')') || (v=='{'&&c!='}') || (v=='['&&c!=']')) {
					return false;
				}
			}
		}
		return stack.empty();
	}
}