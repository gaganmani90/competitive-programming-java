package problemSolving.hackerrank.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		List<Boolean> output = new ArrayList<Boolean>();
		
		for(int i=0; i<t; i++){
			String s = sc.next();
			output.add(isFunny(s));
		}
		
		for(Boolean isFunny : output){
			if(isFunny == true){
				System.out.println("Funny");
			}
			else{
				System.out.println("Not Funny");
			}
		}
	}
	
	private static boolean isFunny(String s){
		for(int i=1,j=s.length()-1; i<s.length(); i++,j--){
			int diff1 = Math.abs(s.charAt(i) - s.charAt(i-1));
			int diff2 = Math.abs(s.charAt(j) - s.charAt(j-1));
			if(diff1 != diff2){
				return false;
			}
		}
		
		return true;
		
	}

}
