package hackerrank.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * You are given a list of size , initialized with zeroes. You have to perform  operations on the list and output the maximum of final values of all the  elements in the list. For every operation, you are given three integers ,  and  and you have to add value  to all the elements ranging from index  to (both inclusive).

Input Format

First line will contain two integers  and  separated by a single space.
Next  lines will contain three integers ,  and  separated by a single space.
Numbers in list are numbered from  to .

Constraints






Output Format

A single line containing maximum value in the updated list.

Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
Explanation

After first update list will be 100 100 0 0 0. 
After second update list will be 100 200 100 100 100.
After third update list will be 100 200 200 200 100.
So the required answer will be 200.
 * @author gagamani
 *
 */
public class AlgorithmicCrush {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long[] list = new long[n]; //size of n
		
		int[][] abk = new int[m][];
		long max = Integer.MIN_VALUE;
		for(int i=0; i<m; i++){
			
			abk[i] = new int[3];
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();
			list[a-1] += k;
            list[b-1]   -= k;
			
			
		}
		
		/* Find max value */
        long sum = 0;
       // long max = 0;
        for (int i = 0; i < n; i++) {
            sum += list[i];
            max = Math.max(max, sum);
        }
        
		System.out.println(max);
	}
		
   private static long getMax(long[] list, int[][] abk){
	   long max = Integer.MIN_VALUE;
	   for(int i=0; i<abk.length; i++){
		   int a=0,b=0,k=0;
			    k = abk[i][2];
			    a = abk[i][0];
			    b = abk[i][1];

		for(int j=(a-1); j<b; j++){
			list[j] += k;
			if(list[j] > max){
				max = list[j];
			}
		}
		   //System.out.println(Arrays.toString(list));
	   }
	   
	   //System.out.println(Arrays.toString(list));
	   
	   return max;
   }
	

}
