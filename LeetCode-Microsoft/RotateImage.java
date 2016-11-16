/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).
*/

public class Solution{
	public void Rotate(int[][] matrix){
		//horizontal swap
		for (int r=0; r<matrix.length/2 ;r++ ) {
			int temp[] = matrix[r];
			matrix[r] = matrix[matrix.length-1-r];
			matrix[matrix.length-1-r] = temp;
		}

		//transpose
		for (int r=0; r<matrix.length ;r++ ) {
			for (int c=r+1;c<matrix[r].length ;c++ ) {
				int temp = matrix[r][c];
				matrix[r][c] = matrix[c][r];
				matrix[c][r]=temp;
			}
		}
	}

}