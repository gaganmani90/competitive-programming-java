package problemSolving.codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * https://www.codechef.com/APRIL20B/problems/STRNO
 *
 *
 * When Varsha was travelling home, she saw a mysterious villa. Varsha is curious about this strange villa and wants to explore it. When she reached the entry gate, the guard gave her a problem to solve and said that he would allow her to enter the villa only if she solved it.
 *
 * The guard gave Varsha two integers X
 *  and K
 * . Varsha needs to determine whether there is an integer A
 *  such that it has exactly X
 *  positive integer divisors and exactly K
 *  of them are prime numbers.
 *
 * Varsha found this problem really hard to solve. Can you help her?
 *
 * Input
 * The first line of the input contains a single integer T
 *  denoting the number of test cases. The description of T
 *  test cases follows.
 * The first and only line of each test case contains two space-separated integers X
 *  and K
 * .
 * Output
 * For each test case, print a single line containing one integer: 1
 *  if a valid integer A
 * exists or 0
 *  if it does not exist.
 *
 * Constraints
 * 1≤T≤103
 * 1≤X,K≤109
 * Subtasks
 * Subtask #1 (15 points):
 *
 * T≤100
 * K≤2
 * Subtask #2 (85 points): original constraints
 *
 * Example Input
 * 1
 * 4 2
 * Example Output
 * 1
 * Explanation
 * Example case 1: A=6
 *  has X=4
 *  factors: 1
 * , 2
 * , 3
 *  and 6
 * . It also has exactly K=2
 *  prime factors: 2
 *  and 3
 * .
 */
public class StrangeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int X, K;
        for(int i = 0; i < tests; i++) { //number of test cases
            X = sc.nextInt();
            K = sc.nextInt();
            System.out.println(strangeNumber(X, K));
        }
    }

    /**
     *
     * TODO: this logic is not working in codeChef, revisit.
     * @param numOfDivisors number of divisors
     * @param numOfPrimeNumbers number of prime numbers
     * @return
     */
    public static int strangeNumber(int numOfDivisors, int numOfPrimeNumbers) {
        int strangeNumber = 1; //integer that has numOfDivisors divisors and numOfPrimeNumbers prime numbers
        Map<Integer, Integer> primeFactor = primeFactors(strangeNumber);
        int[] factors = numOfFactors(primeFactor);
        int divisors = factors[0];
        int primeCount = factors[1];
        while(primeFactor.size() <= numOfPrimeNumbers) {
            if(primeCount == numOfPrimeNumbers && divisors == numOfDivisors) {
                return strangeNumber;
            }
            strangeNumber++;

            primeFactor = primeFactors(strangeNumber);
            factors = numOfFactors(primeFactor);
            divisors = factors[0];
            primeCount = factors[1];
        }
        return 0;
    }

     static Map<Integer, Integer> primeFactors(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        while (num % 2 == 0) {
            num = num / 2;
            map.merge(2, 1, Integer::sum);
        }

        for(int i = 3; i <= Math.sqrt(num); i+=2) {
            while(num % i == 0) {
                map.merge(i, 1, Integer::sum);
                num = num / i;
            }
        }

        if(num > 2) {
            map.merge(num, 1, Integer::sum);
        }

        return map;
    }

    /**
     * Factors = (1+a1) * (1+a2) * (1+a3) * … (1+an)
     *
     * where a1, a2, a3 …. an are count of distinct prime factors of n.
     * @param primeFactors
     * @return
     */
    private static int[] numOfFactors(Map<Integer, Integer> primeFactors) {
        int[] arr = new int[2]; //0-divisor, 1-prime
        arr[0] = 1;
        for(Integer value : primeFactors.values()) {
            arr[0] *= (1+value);
            arr[1] += value;
        }
        return arr;
    }

}
