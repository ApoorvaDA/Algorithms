/*
Objec­tive: Given two strings, s1 and s2 and edit oper­a­tions (given below). 

Inser­tion — Insert a new character.
Dele­tion — Delete a character.
Replace — Replace one char­ac­ter by another.

Write an algo­rithm to find min­i­mum num­ber oper­a­tions required to con­vert string s1 into s2.

Example:
String s1 = "horizon"
String  s2 = "horzon"
Output: 1  {remove 'i' from string s1}

String s1 = "horizon"
String  s2 = "horizontal"
Output: 3  {insert 't', 'a', 'l' characters in string s1}

Approach:

Start com­par­ing one char­ac­ter at a time in both strings. Here we are com­par­ing string from right to left (backwards).

Now for every string we there are two options:

If last char­ac­ters in both the strings are same then just ignore the char­ac­ter and solve the rest of the string recursively.
Else if last char­ac­ters in both the strings are not same then we will try all the pos­si­ble oper­a­tions ( insert, replace, delete) 
and get the solu­tion for rest of the string recur­sively for each pos­si­bil­ity and pick the min­i­mum out of them.
Let’s say given strings are s1 and s2 with lengths m and n respectively.

case 1: last char­ac­ters are same , ignore the last character.
Recur­sively solve for m-1, n-1

case 2: last char­ac­ters are not same then try all the pos­si­ble oper­a­tions recursively.

1. Insert a char­ac­ter into s1 (same as last char­ac­ter in string s2 so that last char­ac­ter in both the strings are same): 
now s1 length will be m+1, s2 length : n, ignore the last char­ac­ter and Recur­sively solve for m, n-1.

2. Remove the last char­ac­ter from string s1. now s1 length will be m-1, s2 length : n, 
Recur­sively solve for m-1, n.

3. Replace last char­ac­ter into s1 (same as last char­ac­ter in string s2 so that last char­ac­ter in both the strings are same): s1 length will be m, s2 length : n, 
ignore the last char­ac­ter and Recur­sively solve for m-1, n-1.

Choose the min­i­mum of ( a, b, c).
*/

public int editDistanceRecursion (String s1, String s2, int m, int n){
	// If any of the strings is empty, then the number of operations is
	// equal to the length of other string
	if(m==0){
		return n;
	}
	if(n == 0){
		return m;
	}

	// If last characters are same, ignore the last character and make recursive call with last but one character
	if (s1.charAt(m-1)==s2.charAt(n-1)) {
		return editDistanceRecursion(s1,s2,m-1, n-1);
	}

	//If the above two cases are not valid, consider all three operations and choose the minimum among them
	return 1+ Math.minimum(editDistanceRecursion(s1,s2,m,n-1),Math.min­i­mum(editDistanceRecursion(s1,s2,m-1,n),editDistanceRecursion(s1,s2,m-1,n-1)));
}

/*
The worst case complexity of above method is O(n^3). There are many subproblems which are solved repeatedly.
So, there are overlapping subproblems, which can be solved using Dynamic Programming in Bottom-up manner.

Hence, in this method we solve the problem and store it in a two dimensional array and use this solution as needed.
this way we can ensure that each sub problem is solved only once.
*/

public class EditDistanceProblem {

    public int editDistanceDP(String s1, String s2) {
        int [][] solution = new int[s1.length()+1][s2.length()+1];
        
        //base case
        //If any of the string if empty then number of operations
        //needed would be equal to the length of other string
        //(Either all characters will be removed or inserted)
        for (int i = 0; i <=s2.length(); i++) {//all elements will be inserted
            solution[0][i] =i;
        }

        for (int i = 0; i <=s1.length(); i++) {//all elements will be removed
            solution[i][0] =i;
        }

        //solving it bottom-up manner
        int m = s1.length();
        int n = s2.length();
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                //If last characters are matching, ignore the last character
                // then the solution will be same as without the last character.
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    solution[i][j] = solution[i-1][j-1];
                else
                    solution[i][j] = 1 +    Math.min(solution[i][j-1], //Insert
                                            Math.min(solution[i-1][j], // Remove
                                            solution[i-1][j-1])); //Replace
            }
        }
        return solution[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        String s1 = "horizon";
        String s2 = "horizontal";
        EditDistanceProblem ed = new EditDistanceProblem();
        System.out.println("Minimum Edit Distance -(DP): " + ed.editDistanceDP(s1, s2));
    }
}