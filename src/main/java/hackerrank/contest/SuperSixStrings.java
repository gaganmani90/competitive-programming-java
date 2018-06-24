package hackerrank.contest;

import java.util.Scanner;

public class SuperSixStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		System.out.println(superSixCount(n));

	}

	private static int superSixCount(String n){
		int count = 0;

		for(int i=0; i<n.length(); i++){
			if(n.charAt(i) == 0){
				count++;
			}
			else if(n.charAt(i) % 6 == 0){
				count++;
			}
		}

		String str = n;
		for(int i=0; i<str.length()-1; i++){
			for(int j=i+1; j<str.length(); j++){
				String subStr = str.substring(i,j+1);
				if(isDivisibleBy6(subStr)){
					count++;
				}
			}
		}

		return count;
	}

	private static boolean isDivisibleBy6(String s){
		if(s.charAt(0) == '0') {
			return false;
		}
		else if(s.charAt(s.length()-1) % 2 == 0 && sum(s) % 3 == 0){
			return true;
		}
		else{
			return false;
		}
	}

	private static long sum(String s){
		long sum = 0; 

		for(int i=0; i<s.length(); i++){
			sum += s.charAt(i);
		}
		return sum;
	}

}
