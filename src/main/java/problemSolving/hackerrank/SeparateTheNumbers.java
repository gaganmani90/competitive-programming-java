package problemSolving.hackerrank;
import java.util.Scanner;

/**
 * A numeric string, , is beautiful if it can be split into a sequence of two or more positive integers, , satisfying the following conditions:

 for any  (i.e., each element in the sequence is  more than the previous element).
No  contains a leading zero. For example, we can split  into the sequence , but it is not beautiful because  and  have leading zeroes.
The contents of the sequence cannot be rearranged. For example, we can split  into the sequence , but it is not beautiful because it breaks our first constraint (i.e., ).
The diagram below depicts some beautiful strings:

image

You must perform  queries, where each query consists of some string . For each query, print whether or not the string is beautiful on a new line. If it's beautiful, print YES x, where  is the first number of the increasing sequence (if there are multiple such values of , choose the smallest); otherwise, print NO instead.

Input Format

The first line contains an integer denoting  (the number of strings to evaluate). 
Each of the  subsequent lines contains some string  for a query.

Constraints

Each character in  is a decimal digit from  to  (inclusive).
Output Format

For each query, print its answer on a new line (i.e., either YES x where  is the smallest first number of the increasing sequence, or NO).

Sample Input 0

7
1234
91011
99100
101103
010203
13
1
Sample Output 0

YES 1
YES 9
YES 99
NO
NO
NO
NO
 * @author gagamani
 *
 */
public class SeparateTheNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			String s = in.next();
			separateNumbers(s);
		}

	}

	/**
	 *Simple solution
	 * @param
	 * @return
	 */
	public static String separateNumbers2(String input){
		if (input.charAt(0) == '0') {
			return "NO";
		}

		for (int length = 1; length * 2 <= input.length(); length++) {
			long firstNumber = Long.parseLong(input.substring(0, length));

			StringBuilder sequence = new StringBuilder();
			long number = firstNumber;
			while (sequence.length() < input.length()) {
				sequence.append(number);
				number++;
			}
			if (sequence.toString().equals(input)) {
				return firstNumber+"";
			}
		}
		return "NO";
	}

	private static void separateNumbers(String s) {
		int range = 1, num, prevNum = 0;
		boolean isIncremental = true;
		int firstNum = -1;
		
		if(s.length() == 1){
			isIncremental = false;
		}

		while(range <= s.length()/2 && s.length() > 1){
			int tempRange = range;
			isIncremental = true;
			prevNum = 0;

			for(int i = 0 ; i< s.length();){

				if(i >= s.length() || i+range > s.length() || s.length() == 1){
					isIncremental = false;
					break;
				}
				num = Integer.parseInt((s.substring(i, i+tempRange)));
				if(i == 0){
					firstNum = num;
				}
			
				
				if((num != prevNum+1 && i!=0) || Integer.toString(num).length() != tempRange) {
					//System.out.println(num+"!="+prevNum);
					isIncremental = false;
					break;
				}
				i+=(tempRange);
				if(i == s.length()) {
					isIncremental = true;
					
				}
				if(isAll9(num)) tempRange++;
				prevNum = num;


			}
			if(isIncremental == true) break;
				range++;
		}

		if(isIncremental == true){
			System.out.println("YES"+" "+firstNum);
		}
		else{
			System.out.println("NO");
		}
		//System.out.println((isIncremental == true ? "YES" : "NO")+" "+s);

	}

	private static boolean isAll9(int num){

		int newLength = ((num+1)+"").length();
		if(newLength == Integer.toString(num).length()+1 ){
			//System.out.println("All 9");
			return true;
		}
		else{
			return false;
		}
	}

}
