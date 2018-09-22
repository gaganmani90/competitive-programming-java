/**
 * Check out the resources on the page's right side to learn more about stacks. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.

Input Format

The first line contains a single integer, , denoting the number of strings. 
Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.

Constraints


, where  is the length of the sequence.
Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
Output Format

For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.

Sample Input

3
{[()]}
{[(])}
{{[[(())]]}}
Sample Output

YES
NO
YES
Explanation

The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
The string {[(])} is not balanced, because the brackets enclosed by the matched pairs [(] and (]) are not balanced. Thus, we print NO on a new line.
The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.
 */

package problemSolving.crackingCode;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

	private static HashMap<Character, Character> bracketMap = new HashMap<Character, Character>();
	public static void main(String[] args) {
		initMap();
		
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int i=0; i<cases; i++){
			System.out.println(isBracketsBalanced(sc.next()));
		}
		
	}
	
	private static void initMap(){
		bracketMap.put('(', ')');
		bracketMap.put('{', '}');
		bracketMap.put('[', ']');
	}
	
	private static String isBracketsBalanced(String brackets){
		String isBalanced = "YES";
		if(brackets.length() % 2 != 0){
			isBalanced = "NO";
		}
		else{
			Stack<Character> oneSideBrackets = new Stack<Character>();
			for(int i=0; i<brackets.length(); i++){
				char currChar = brackets.charAt(i);
				if(bracketMap.containsKey(currChar)){
					oneSideBrackets.push(brackets.charAt(i));
				}
				else if(oneSideBrackets.empty()){
					isBalanced = "NO";
					break;
				}
				else if(bracketMap.containsKey(oneSideBrackets.peek())
						&& bracketMap.get(oneSideBrackets.peek()) == currChar){
					oneSideBrackets.pop();
				}
				
			}
			
			if(!oneSideBrackets.empty()){
				isBalanced = "NO";
			}
		}
		return isBalanced;
	}

}
