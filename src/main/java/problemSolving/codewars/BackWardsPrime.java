package problemSolving.codewars;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author gaganmani
 * @date 17/10/18
 * @package problemSolving.codewars
 */
public class BackWardsPrime {

    public static String backwardsPrime(long start, long end) {
        Set<Long> backwardPrimeSet = new LinkedHashSet<>();

        for(long num = start; num <= end; num++){
            long reverseNum = reverseNumber(num);
            if(reverseNum == num){
                continue;
            }
            if(backwardPrimeSet.contains(reverseNum)){
                backwardPrimeSet.add(num);
            }
            else if(isPrime(num) && isPrime(reverseNum)){
                backwardPrimeSet.add(num);
            }
        }
        return formOutput(backwardPrimeSet).trim();
    }

    private static String formOutput(Set<Long> output){
        StringBuilder builder = new StringBuilder();

        for(Long num : output){
            builder.append(num+ " ");
        }
        return builder.toString();
    }

    private static boolean isPrime(long n){
        long root = (long)Math.sqrt(n) + 1;

        if(n == 0 || n == 1){
            return false;
        }
        if(n % 2 == 0){
            return false;
        }

        for(int i = 3; i <= root; i+=2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param n 123
     * @return 321
     */
    private static long reverseNumber(long n){
        long reverse = 0;
        int numOfDigits = (int)Math.log10(n) + 1;

        if(numOfDigits == 1){
            return n;
        }

        while(n != 0){
            long rem = n % 10;
            reverse += rem * (long)Math.pow(10, numOfDigits-1);
            numOfDigits--;
            n = n/10;
        }

        return reverse;
    }
}
