public class Solution{
	public boolean isPalindrome(String s){
		if(s==null || s.isEmpty()){
			return true;
		} else {
			s = s.trim().toLowerCase();
			int i=0;
			int j=s.length()-1;
			while(i<j){
				while(!Character.isLetterOrDigits(s.charAt(i)) && i<j)
					i++;
				while(!Character.isLetterOrDigits(s.charAt(j)) && i<j)
					j--;
			
				i++;
				j--;		
			}
			return true;
		}
	}
}