package problemSolving.codewars;

/**
 * You are given an array strarr of strings and an integer k. Your task is to return the first longest string consisting of k consecutive strings taken in the array.

Example:

longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"

n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 * @author gaganmani
 *
 */
public class ConsecutiveString {
	public static void main(String[] args) {
		System.out.println(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 5));
	}
	
	 public static String longestConsec(String[] strarr, int k) {
	        String out = "";
	        int maxNum = -1;
	        
	        
	        if(strarr.length == 0 || k>strarr.length || k<=0){
	        	return out;
	        }
	        else{
	        	for(int i=0; i<strarr.length+1-k;i++){
	        		int j=i;
	        		String strConc = "";
	        		for(int ind=j; ind<k+j; ind++){
	        			strConc+=strarr[ind];
	        		}
	        		if(strConc.length() > maxNum){
        				maxNum = strConc.length();
        				out = strConc;
        			}
	        	}
	        	
	        }
	        return out;
	    }
}
