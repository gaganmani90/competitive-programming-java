package problemSolving.hackerrank.contest;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 
 * Not scalable, failing for big numbers.
 * @author gagamani
 *
 */
public class Megaprime {

	private static HashSet<Long> primeSet = getPrimeSet();
	private static HashSet<Long> megaPrimeSet = new HashSet<Long>();
	static int hit = 1;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long first = in.nextLong();
		long last = in.nextLong();



		long t1 = System.currentTimeMillis()/1000;
		System.out.println(getMegaPrimeNumberCount(first, last));
		long t2 = System.currentTimeMillis()/1000;

		System.out.println((t2-t1));
	}

	private static int getMegaPrimeNumberCount(long a, long b){
		int count = 0;
		for(long i = a; i <= b; i++){
			long t1 = System.currentTimeMillis();
			if(isPrime(i) && isMegaPrime(i)){
				count++;
			}
			long t2 = System.currentTimeMillis();
			//System.out.println((t2-t1));
		}

		return count;
	}

	private static boolean isMegaPrime(long n){

		long copyn = n;
		boolean isMegaPrime = true;

		if(megaPrimeSet.contains(n) && n != 1){
			return true;
		}
		else{
			long rem, div;
			while(n != 0){
				rem = n%10;
				n = n/10;

				if(!primeSet.contains(rem)){
					isMegaPrime = false;
					break;
				}
				else if(megaPrimeSet.contains(n)){
					//System.out.println(n+":"+hit++);
					isMegaPrime = true;
					break;
				}
			}
			if(isMegaPrime){
				if(primeSet.contains(copyn) || isPrime(copyn)){
					megaPrimeSet.add(copyn);
				}
			}

		}
		return isMegaPrime;
	}
	private static HashSet<Long> getPrimeSet(){
		HashSet<Long> primeDigits = new HashSet<Long>();
		primeDigits.add(2L);
		primeDigits.add(3L);
		primeDigits.add(5L);
		primeDigits.add(7L);
		return primeDigits;
	}

	private static boolean isPrime(long num){
		if(primeSet.contains(num)){
			return true;
		}
		else{
			if(num == 0 || num == 1){
				return false;
			}
			else if ( num > 2 && num%2 == 0 ) {
				return false;
			}
			int top = (int)Math.sqrt(num) + 1;
			for(int i = 3; i < top; i+=2){
				if(num % i == 0){
					return false;
				}
			}
			primeSet.add(num);
			return true;
		}

	}

}


