package problemSolving.codechef;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Chef owns N
 *  cars (numbered 1
 *  through N
 * ). He wishes to sell all of them over N
 * years by selling exactly one car per year. For each valid i
 * , the initial price of the i
 * -th car is Pi
 * . Due to depreciation, the price of each car decreases by 1
 *  unit per year until it is sold.
 *
 * Note that the price of a car cannot drop below 0
 *  no matter how many years have passed, i.e. when the price of a car reaches 0
 *  in some year, it remains 0
 *  in all subsequent years.
 *
 * Find the maximum profit Chef can make if he sells his cars in an optimal way. Since this number may be large, compute it modulo 1,000,000,007
 *  (109+7
 * ).
 *
 * Input
 * The first line of the input contains a single integer T
 *  denoting the number of test cases. The description of T
 *  test cases follows.
 * The first line of each test case contains a single integer N
 * .
 * The second line contains N
 *  space-separated integers P1,P2,…,PN
 * .
 * Output
 * For each test case, print a single line containing one integer ― the maximum profit Chef can make, modulo 1,000,000,007
 * .
 *
 * Constraints
 * 1≤T≤25
 * 1≤N≤105
 * 0≤Pi≤109
 *  for each valid i
 * Subtasks
 * Subtask #1 (30 points): N≤2⋅103
 *
 * Subtask #2 (70 points): original constraints
 *
 * Example Input
 * 2
 * 3
 * 6 6 6
 * 3
 * 0 1 0
 * Example Output
 * 15
 * 1
 * Explanation
 * Example case 1:
 *
 * During the first year, Chef's profit so far is 0
 *  and the prices of the cars are [6,6,6]
 * . Chef sells one of these cars.
 * During the second year, Chef's profit so far is 6
 *  and the prices of the remaining cars are [5,5]
 * . Again, Chef sells one of these cars.
 * During the third year, Chef's profit so far is 11
 *  and there is one car with price 4
 * . Chef sells this car.
 * In the fourth year, Chef has sold all of his cars and his profit is 15
 * . This is the maximum profit he can make.
 * Example case 2:
 *
 * During the first year, Chef's profit so far is 0
 *  and the prices of the cars are [0,1,0]
 * . Chef sells the second car.
 * During the second year, Chef's profit so far is 1
 *  and the prices of the remaining cars are [0,0]
 * . Chef sells one of these cars.
 * During the third year, Chef's profit so far is 1
 *  and there is one car with price 0
 * . Chef sells this car.
 * During the fourth year, Chef has sold all his cars and his profit is 1
 */
public class SellAllTheCars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        long[][] testCases = new long[tests][];
        for(int i = 0; i < tests; i++) { //number of test cases
            int count = sc.nextInt(); //get size of array
            long[] carsPrices = new long[count];
            for (int j = 0; j < count; j++) {
                carsPrices[j] = sc.nextLong(); //initialize
            }
            testCases[i] = carsPrices;
        }
        for(long[] positions : testCases) {
            System.out.println(getProfit(positions));
        }
    }

    public static int getProfit(long[] carPrices) {
        int modulo = 1000000007;
        //max heap -> reverse order priority queue
        PriorityQueue<Long> prices = new PriorityQueue(carPrices.length, Collections.reverseOrder());
        for(long price : carPrices) {
            prices.add(price);
        }

        long totalProfit = 0;
        int years = prices.size();

        for(int year = 0; year < years; year++) {
            //break if max car price has reached 0
            if((prices.peek() - year) <= 0) {
                break;
            }
            long sellPrice = prices.poll() - year;
            totalProfit += sellPrice;
        }
        return (int)(totalProfit % modulo);
    }
}
