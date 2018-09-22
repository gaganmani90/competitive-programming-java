
package problemSolving.codewars;

/**
 * Some numbers have funny properties. For example:

89 --> 8¹ + 9² = 89 * 1

695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2

46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p we want to find a positive integer k, if it exists, such as the sum of the digits of n taken to the successive powers of p is equal to k * n. In other words:

Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
If it is the case we will return k, if not return -1.
 * @author gaganmani
 *
 */
public class DigPow {

	public static void main(String[] args) {
		System.out.println(digPow(89, 1));
		System.out.println(digPow(92, 1));
		System.out.println(digPow(695, 2));
		System.out.println(digPow(46288, 3));

	}
	
	public static long digPow(int n, int p) {
		long sum = 0;
		int copyN=n,tempN = n;
		int digitCount = 0;
		
		//digit count
		while(tempN != 0){
			tempN = tempN/10;
			digitCount++;
		}
		
		
		while(n != 0){
			sum += Math.pow(n%10, p+digitCount-1);
			digitCount--;
			n = n/10;
		}
		if(sum % copyN == 0 ){
			return sum/copyN;
		}
		else{
			return -1;
		}
	}

}
