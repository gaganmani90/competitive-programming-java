package problemSolving.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Best Approach: If you go through number theory, you will find an efficient way to find the number of factors.
 * If we take a number, say in this case 30, then the prime factors of 30 will be 2, 3, 5 with count of each of these being 1 time, so total number of factors of 30 will be (1+1)*(1+1)*(1+1) = 8.
 * Therefore, the general formula of total number of factors of a given number will be:
 *
 * Factors = (1+a1) * (1+a2) * (1+a3) * … (1+an)
 *
 * where a1, a2, a3 …. an are count of distinct prime factors of n.
 *
 * Let’s take another example to make things more clear. Let the number be 100 this time,
 * So 100 will have 2, 2, 5, 5. So the count of distinct prime factors of 100 are 2, 2. Hence number of factors will be (2+1)*(2+1) = 9.
 */
public class NumberOfFactors {

    /**
     * O( n * sqrt(n))
     * @param num
     * @return
     */
    public static int factors(int num) {
        int count = 0;
        Map<Integer, Integer> map = primeFactors(num);
        for(Integer value : map.values()) {
            count += value;
        }
        return count;
    }

    private static Map<Integer, Integer> primeFactors(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        while (num % 2 == 0) {
            num = num / 2;
            map.merge(2, 1, Integer::sum);
        }

        for(int i = 3; i < Math.sqrt(num); i+=2) {
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
}
