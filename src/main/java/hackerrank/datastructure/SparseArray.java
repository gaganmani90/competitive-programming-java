package hackerrank.datastructure;

import java.util.HashMap;
import java.util.Scanner;

/**
 * There are  strings. Each string's length is no more than  characters. There are also  queries. For each query, you are given a string, and you need to find out how many times this string occurred previously.

Input Format

The first line contains , the number of strings.
The next  lines each contain a string.
The nd line contains , the number of queries.
The following  lines each contain a query string.

Constraints

 
 
    

Sample Input

4
aba
baba
aba
xzxb
3
aba
xzxb
ab
Sample Output

2
1
0
Explanation

Here, "aba" occurs twice, in the first and third string. The string "xzxb" occurs once in the fourth string, and "ab" does not occur at all.
 * @author gagamani
 *
 */
public class SparseArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//String[] strings = new String[n];
		HashMap<String, Integer> strings = new HashMap<String, Integer>();
		
		for(int i=0; i<n; i++){
			String s = sc.next();
			if(strings.containsKey(s)){
				strings.put(s, strings.get(s)+1);
			}
			else{
				strings.put(s, 1);
			}
		}
		
		int q = sc.nextInt();
		String[] queries = new String[q];
		for(int i=0; i<q; i++){
			queries[i] = sc.next();
		}
		
		//Printing output
		for(int i=0; i<q; i++){
			if(strings.containsKey(queries[i])){
				System.out.println(strings.get(queries[i]));
			}
			else{
				System.out.println(0);
			}
		}

	}

}
