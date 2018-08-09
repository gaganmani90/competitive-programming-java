package hackerrank;

import java.util.*;

public class MaxSubArraySum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int arrs[][] = new int[cases][];

        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            arrs[i] = new int[n];
            for (int j = 0; j < n; j++) {
                arrs[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < cases; i++) {
            System.out.println(maxSubArraySum_adjacent(arrs[i]));
        }
    }


    public static int maxSubArraySum_adjacent(int a[]) {
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < a.length; i++) {
            curr_max = max(a[i], curr_max + a[i]);
            max_so_far = max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}