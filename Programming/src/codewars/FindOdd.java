package codewars;

/**
 * Given an array, find the int that appears an odd number of times.

There will always be only one integer that appears an odd number of times.
 * @author gaganmani
 *
 */
public class FindOdd {

	public static void main(String[] args) {
		//System.out.println(FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
		
		System.out.println(1^4);

	}

	public static int findIt(int[] A) {
		int out = 0;
		//maintain count of each integer
		for(int num : A){
			out ^= num;
		}
		
	  	return out;
	  }
}
