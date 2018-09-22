package problemSolving.hackerrank.contest;

import java.util.Scanner;

public class BigString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        
        printArray(sort(unsorted));
        
        
		
		//System.out.println(isBigger("31415926535897932384626433832795", "31415926535897932384626433832778"));
    }

	private static void printArray(String[] array){
		for(String currString : array){
			System.out.println(currString);
		}
	}
  private static String[] sort(String[] unsorted){
	  int n = unsorted.length;  
      for (int j = 1; j < n; j++) {  
          String key = unsorted[j];  
          int i = j-1;  
          while ( (i > -1) && isBigger(unsorted[i], key)) {  
        	  unsorted [i+1] = unsorted [i];  
              i--;  
          }  
          unsorted[i+1] = key;  
      }  
	  return unsorted;
  }
  
  private static boolean isBigger(String a, String b){
	  boolean isBigger = false;
	  
	  if(a.length() > b.length()){
		  isBigger = true;
	  }
	  else if(a.length() < b.length()){
		  isBigger = false;
	  }
	  else{
		  for(int i = 0; i < a.length(); i++){
			  int aint = a.charAt(i);
			  int bint = b.charAt(i);
			  if(aint > bint){
				  isBigger = true;
				  break;
			  }
			  else if(bint > aint){
				  isBigger = false;
				  break;
			  }
		  }
	  }
	  return isBigger;
  }

}
