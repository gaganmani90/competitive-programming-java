package problemSolving.general;

/**
 * @author gaganmani
 * @date 21/12/18
 * @package problemSolving.general
 */
public class PrimeAssignment {

    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        } else if (num > 2 && num % 2 == 0) {
            return false;
        }
        int top = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < top; i += 2) {
            if (isDivisor(num, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDivisor(int number, int divisor){
        if(number % divisor == 0){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * Print all prime numbers less than N
     */
    public static void printPrimeNumbers(int N){
        for(int i = 2; i <= N; i++){
            if(isPrime(i)){
                System.out.println(i+" ");
            }

        }

    }
}
