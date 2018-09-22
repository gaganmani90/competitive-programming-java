package problemSolving.hackerrank.projectEuler;

import java.util.Scanner;

public class PathSumTwoWays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				matrix[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(minCost(matrix, n-1, n-1));
		
		//System.out.println(minCostRec(matrix, n-1, n-1));
		
	}
	
	private static int minCost(int[][] cost, int m, int n){
		int i, j;
        int tc[][]=new int[m+1][n+1];
 
        tc[0][0] = cost[0][0];
 
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = Math.min(tc[i-1][j],
                               tc[i][j-1]) + cost[i][j];
 
        return tc[m][n];
	}
	
	private static int minCostRec(int[][] cost, int m, int n){
		
		if(n < 0 || m<0){
			return Integer.MAX_VALUE;
		}
		else if(n == 0 && m==0){
			return cost[m][n];
		}
		else{
			 return cost[m][n] + Math.min(minCostRec(cost, m-1, n), 
					 minCostRec(cost, m, n-1) );
		}
	}

}
