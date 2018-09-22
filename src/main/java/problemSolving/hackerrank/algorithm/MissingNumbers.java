package problemSolving.hackerrank.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * Numeros, the Artist, had two lists  and , such that  was a permutation of . Numeros was very proud of these lists. Unfortunately, while transporting them from one exhibition to another, some numbers were left out of . Can you find the missing numbers?

Notes

If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in  is less than or equal to .
Input Format

There will be four lines of input:

 - the size of the first list 
This is followed by  space-separated integers that make up the first list. 
 - the size of the second list 
This is followed by  space-separated integers that make up the second list.

Constraints

Output Format

Output the missing numbers in ascending order.

Sample Input

10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output

204 205 206
Explanation

 is present in both arrays. Its frequency in  is , while its frequency in  is . Similarly,  and  occur twice in , but thrice in . So, these three numbers are our output. The rest of the numbers have thesame frequency in both lists.
 */
public class MissingNumbers {

	private static HashMap<Integer, Integer> amap = new HashMap<Integer, Integer>();
	private static HashMap<Integer, Integer> bmap = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
			if(amap.containsKey(A[i])){
				amap.put(A[i], amap.get(A[i])+1);
			}
			else{
				amap.put(A[i], 1);
			}
		}
		
		int m = sc.nextInt();
		int[] B = new int[m];
		for(int i=0; i<m; i++){
			B[i] = sc.nextInt();
			if(bmap.containsKey(B[i])){
				bmap.put(B[i], bmap.get(B[i])+1);
			}
			else{
				bmap.put(B[i], 1);
			}
		}
		
		
		for(int key : getMissingNumbers()){
			System.out.print(key+" ");
		}

	}
	
	private static List<Integer> getMissingNumbers(){
		List<Integer> missing = new ArrayList<Integer>();
		
		for(int key : bmap.keySet()){
			if(!amap.containsKey(key)){
				missing.add(key);
			}
			else if(Math.abs(amap.get(key) - bmap.get(key)) != 0){
				missing.add(key);
			}
		}
		
		Collections.sort(missing);
		return missing;
	}

}
