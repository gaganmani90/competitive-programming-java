package problemSolving.general;

/**
 * @author gaganmani
 * @date 21/12/18
 * @package problemSolving.general
 */
public class DivisorSumAssignment {

    public static boolean isDivisor(int number, int divisor){
        if(number % divisor == 0){
            return true;
        }
        else{
            return false;
        }

    }

    public static int divisorSum(int number){
        int sum = 0;

        for(int div = 1; div <= number/2; div++){
            if(isDivisor(number, div)){
                sum += div;
            }
        }

        return sum;

    }
}
