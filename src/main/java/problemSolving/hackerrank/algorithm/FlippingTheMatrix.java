package problemSolving.hackerrank.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sean invented a game involving a  matrix where each cell of the matrix contains an integer. He can reverse any of its rows or columns any number of times, and the goal of the game is to maximize the sum of the elements in the  submatrix located in the upper-left corner of the  matrix (i.e., its upper-left quadrant).

Given the initial configurations for  matrices, help Sean reverse the rows and columns of each matrix in the best possible way so that the sum of the elements in the matrix's upper-left quadrant is maximal. For each matrix, print the maximized sum on a new line.

Input Format

The first line contains an integer, , denoting the number of queries. The subsequent lines describe each of the queries in the following format:

The first line of each query contains an integer, .
Each line  the  subsequent lines contains  space-separated integers describing the respective values of row  in the matrix.
Constraints

, where .
Output Format

You must print  lines of output. For each query (i.e., matrix), print the maximum possible sum of the elements in the matrix's upper-left quadrant.

Sample Input

1
2
112 42 83 119
56 125 56 49
15 78 101 43
62 98 114 108
Sample Output

414
Explanation

We start out with the following  matrix:

We can perform the following operations to maximize the sum of the  submatrix in the upper-left corner:

Reverse column  (), resulting in the matrix: 
Reverse row  (), resulting in the matrix: 
When we sum the values in the  submatrix in the upper-left quadrant, we get . Thus, we print  on a new line.
 * @author gagamani
 *
 */
public class FlippingTheMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int matrix[][] = new int[2*n][2*n]; 

		for(int i=0; i<2*n; i++){
			for(int j=0; j<2*n; j++){
				matrix[i][j] = sc.nextInt();
			}
		}

		System.out.println(getMaxNSum(matrix));

	}

	private static int getMaxNSum(int[][] matrix) {
		int sum = 0;

		//reverse columns if required
		for(int i=0; i<matrix.length; i++){
			int[] column = new int[matrix.length];
			for(int j=matrix.length/2; j<matrix.length; j++){
				column[i] = matrix[j][i];
			}
			if(isReversible(column)){
				matrix = reverse(matrix, false, i);
			}
		}

		//reverse lower half rows if required
		for(int i=(matrix.length/2); i<matrix.length; i++){
			if(isReversible(matrix[i])){
				matrix = reverse(matrix, true, i);
			}
		}
		//printMatrix(matrix);



		for(int i=0; i<matrix.length/2; i++){
			for(int j=0; j<matrix.length/2; j++){
				sum += matrix[i][j];
			}
		}
		printMatrix(matrix);
		return sum;
	}

	private static boolean isReversible(int[] array){
		boolean shouldReverse = false;
		int firstHalfSum = 0;
		int secondHalfSum = 0;
		for(int i=0; i<array.length; i++){
			if(i <= (array.length/2-1)){
				firstHalfSum += array[i];
			}
			else{
				secondHalfSum += array[i];
			}
		}
		if(firstHalfSum < secondHalfSum){
			shouldReverse = true;
		}
		return shouldReverse;
	}

	/**
	 * Reverse a given row or column
	 * @param matrix
	 * @param isRow
	 * @param nth
	 * @return
	 */
	private static int[][] reverse(int[][] matrix, boolean isRow, int nth){

		if(isRow == true){
			int length = matrix[nth].length;
			for(int i = 0; i<matrix[nth].length/2; i++){
				int temp = matrix[nth][i];
				matrix[nth][i] = matrix[nth][length - i - 1];
				matrix[nth][length - i - 1] = temp;
			}
		}
		else{
			int length = matrix.length;
			for(int i = 0; i<matrix.length/2; i++){
				int temp = matrix[i][nth];
				matrix[i][nth] = matrix[length - i - 1][nth];
				matrix[length - i - 1][nth] = temp;
			}
		}
		return matrix;
	}

	private static void printMatrix(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
