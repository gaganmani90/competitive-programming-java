package problemSolving.codechef;

import java.util.Scanner;

/**
 * Input
 * The first line of the input contains a single integer T
 *  denoting the number of test cases. The description of T
 *  test cases follows.
 * The first line of each test case contains a single integer N
 * .
 * The next line contains N
 *  space-separated integers A1,A2,…,AN
 * .
 * Output
 * For each test case, print a single line containing the string "YES" if social distancing is being followed or "NO" otherwise (without quotes).
 *
 * Constraints
 * 1≤T≤100
 * 1≤N≤100
 * 0≤Ai≤1
 *  for each valid i
 * at least one spot is occupied
 * Subtasks
 * Subtask #1 (100 points): original constraints
 *
 * Example Input
 3
 3
 1 0 1
 7
 1 0 0 0 0 0 1
 11
 0 1 0 0 0 0 0 1 0 0 1
 * Example Output
 * NO
 * YES
 * NO
 * Explanation
 * Example case 1: The first and third spots are occupied and the distance between them is 2
 *  feet.
 *
 * Example case 2: The first and seventh spots are occupied and the distance between them is 6
 *  feet.
 */
public class CovidPandemicLongQueue {

    static final int DISTANCING_LIMIT = 6;

    enum DistancingType {
        YES("YES"), NO("NO");
        private String value;
        DistancingType(String val) {
            this.value = val;
        }
    }

    /**
     * Return YES if everyone is standing atleast 6 feet apart, else NO
     * @param positions
     * @return
     */
    public static String isSocialDistancingFollowed(int[] positions) {
        int position = -1;
        int minPosition = Integer.MAX_VALUE;
        for(int i = 0; i < positions.length; i++) {
            if(positions[i] == 1) {
                //initialize
                if(position == -1) {
                    position = i;
                    continue;
                }
                minPosition = Math.min(Math.abs(position - i), minPosition);
                if(minPosition < DISTANCING_LIMIT) {
                    return DistancingType.NO.value;
                } else { //move to next 1
                    position = i;
                }
            }
        }
        return DistancingType.YES.value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int[][] testCases = new int[tests][];
        for(int i = 0; i < tests; i++) { //number of test cases
            int count = sc.nextInt(); //get size of array
            int[] positions = new int[count];
            for (int j = 0; j < count; j++) {
                positions[j] = sc.nextInt(); //initialize
            }
            testCases[i] = positions;
        }
        for(int[] positions : testCases) {
            System.out.println(isSocialDistancingFollowed(positions));
        }
    }

}
