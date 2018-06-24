package codewars;

import java.util.Arrays;

public class MainTest {

	public static void main(String[] args) {
		String a[] = new String[]{ "tarp", "mice", "bull"};
    	String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
    	String r[] = new String[] { "arp", "live", "strong" };
    	
    	System.out.println(Arrays.toString(WhichAreIn.inArray(a, b)));
	}
}

 class WhichAreIn { 
	
	public static String[] inArray(String[] array1, String[] array2) {
    String[] out = new String[array1.length];
    boolean isFound = false;
    int i=0;
    String temp = "";
    for(String a2 : array2){
    	
      for(String a1 : array1){
    	 
        if(a2.contains(a1) && !a1.equals(temp)){
        	//System.out.println("a2:"+a2+" a1: "+a1);
          out[i++] = a1;
          isFound = true;
           temp = a1;
          break;
        }
        
      }
    }
    
    if(!isFound){
    	return null;
    }
    if(i !=0)
     Arrays.sort(out);
		 return out;
	}
}

