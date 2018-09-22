package problemSolving.codewars;

import java.util.Arrays;

public class SequenceSum {
public static void main(String[] args) {
	System.out.println(Arrays.toString(sumOfN(-7)));
}

public static int[] sumOfN(int n) {
    boolean isNegative = false;
    if(n < 0){
      isNegative = true;
      n = Math.abs(n);
    }
    if(n == 0){
      return new int[]{0};
    }
    
    int[] out = new int[n+1];
    int sum = 0;
    int start = 0;
    for(int i=0; i<out.length; i++){
    	sum += start;
    	start++;
    	out[i] = sum;
    }
    
    if(isNegative){
    	for(int i=0; i<out.length; i++){
    		out[i]*=(-1);
    	}
    }
	return out;
    
  }
}
