/**
 * String  always consists of two distinct alternating characters. For example, if string 's two distinct characters are x and y, then t could be xyxyx or yxyxy but not xxyy or xyyx.

You can convert some string  to string  by deleting characters from . When you delete a character from , you must delete all occurrences of it in . For example, if  abaacdabd and you delete the character a, then the string becomes bcdbd.

Given , convert it to the longest possible string . Then print the length of string  on a new line; if no string  can be formed from , print  instead.

Input Format

The first line contains a single integer denoting the length of . 
The second line contains string .

Constraints


 only contains lowercase English alphabetic letters (i.e., a to z).
Output Format

Print a single integer denoting the maximum length of  for the given ; if it is not possible to form string , print instead.

Sample Input

10
beabeefeab
Sample Output

5
 */
package hackerrank.algorithm;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwiCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		System.out.println(getStringLength(sc.next()));
	}

	private static int getStringLength(String str){
		int maxCount = 0;
		char[] uniqArr = getUniqueArray(str);
		if(uniqArr.length < 2){
			return 0;
		}

		for(int i=0; i<uniqArr.length-1; i++){
			for(int j=i+1; j<uniqArr.length; j++){
				int len = getTwoCharStringLength(str, uniqArr[i],	uniqArr[j]);
				if(len > maxCount){
					maxCount = len;
				}
			}
		}
		return maxCount;

	}

	private static char[] getUniqueArray(String str){
		Set<Character> uniqueChars = new HashSet<Character>();
		for(int i=0; i<str.length(); i++){
			uniqueChars.add(str.charAt(i));
		}
		char[] uniqArr = new char[uniqueChars.size()];
		int i=0;
		for (Character c : uniqueChars) {
			uniqArr[i++] = c;
		}
		return uniqArr;
	}

	private static int getTwoCharStringLength(String str, final char a, final char b){
		int count = 0;
		boolean aOccured = false;
		boolean bOccured = false;
		for(int i=0; i<str.length(); i++){
			char currChar = str.charAt(i);
			if(currChar == a){
				if(aOccured == true){
					count = 0;
					break;
				}
				else{
					bOccured = false;
					aOccured = true;
					count++;
				}
			}

			else if(currChar == b){
				if(bOccured == true){
					count = 0;
					break;
				}
				else{
					bOccured = true;
					aOccured = false;
					count++;
				}
			}
		
	}
	return count;
}

}
