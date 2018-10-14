package problemSolving.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * * The rod-cutting problem is the following. Given a rod of length n inches and a table of prices pi for i D 1; 2; : : : ; n,
 * * determine the maximum revenue rn obtain- able by cutting up the rod and selling the pieces.
 * * Note that if the price pn for a rod of length n is large enough, an optimal solution may require no cutting at all.
 *
 * <pre>
 *     lengthi   1 2 3 4 5 6 7 8 9 10
 *     pricepi   1 5 8 9 10 17 17 20 24 30
 *
 *     for n = 4, p2+p2 = 10 is maximum revenue
 * </pre>
 *
 * @author gaganmani
 * @date 13/10/18
 * @package problemSolving.dynamic_programming
 */
public class RodCuttingProblem {

    private int[] prices; //price of each rod; length starting from 0

    RodCuttingProblem(int[] prices) {
        this.prices = prices;
    }

    /**
     * Exponential run time 2*pow(n)
     * <p>
     * In retrospect, this exponential running time is not so surprising. CUT-ROD explicitly considers all the 2n􏰐1 possible ways of cutting up a rod of length n.
     * The tree of recursive calls has 2n􏰐1 leaves, one for each possible way of cutting up the rod.
     * The labels on the simple path from the root to a leaf give the sizes of each remaining right-hand piece before making each cut.
     * That is, the labels give the corresponding cut points, measured from the right-hand end of the rod.
     *
     * @param n
     * @return
     */
    int maximumRevenue_recursive(int n) {
        return maxRecUtil(n);
    }

    private int maxRecUtil(int nthRode) {
        int max = Integer.MIN_VALUE;
        if (nthRode == 0) {
            return 0;
        }
        for (int ithRode = 0; ithRode < nthRode; ithRode++) {
            max = Math.max(max, this.prices[ithRode] + maxRecUtil(nthRode - ithRode - 1));
        }
        return max;
    }

    /**
     * top down version of dynamic programming
     *
     * The first approach is top-down with memoization.2 In this approach, we write the procedure recursively in a natural manner,
     * but modified to save the result of each subproblem (usually in an array or hash table).
     * The procedure now first checks to see whether it has previously solved this subproblem.
     * If so, it returns the saved value, saving further computation at this level;
     * if not, the procedure computes the value in the usual manner.
     * We say that the recursive procedure has been memoized; it “remembers” what results it has computed previously.
     * O(n2)
     * @param n
     * @return
     */
    int maximumRevenue_topDown(int n) {
        int[] subproblemResults = new int[n + 1];//first element is 0 for intialization purpose
        initialize(subproblemResults);

        return topDownHelper(n, subproblemResults);
    }

    private int topDownHelper(int n, int[] subproblems) {
        int max = 0;
        if (subproblems[n] >= 0) { //if desired value is already knownn
            return subproblems[n];
        }
        if (n == 0) {
            max = 0;
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, this.prices[i] + topDownHelper(n - i - 1, subproblems));
        }
        return max;

    }

    /**
     *
     * The second approach is the bottom-up method. This approach typically depends on some natural notion of the “size” of a subproblem,
     * such that solving any par- ticular subproblem depends only on solving “smaller” subproblems.
     * We sort the subproblems by size and solve them in size order, smallest first.
     * When solving a particular subproblem, we have already solved all of the smaller subproblems its solution depends upon,
     * and we have saved their solutions. We solve each sub- problem only once, and when we first see it,
     * we have already solved all of its prerequisite subproblems.
     *
     * For the bottom-up dynamic-programming approach, BOTTOM-UP-CUT-ROD uses the natural ordering of the subproblems:
     * a problem of size i is “smaller” than a subproblem of size j if i < j .
     * Thus, the procedure solves subproblems of sizes j D 0;1;:::;n, in that order.
     *
     * O(n2)
     *
     * @param n
     * @return
     */
    int maximumRevenue_bottomUp(int n) {

        int[] subproblemResults = new int[n + 1];//first element is 0 for intialization purpose
        initialize(subproblemResults);

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, this.prices[j] + subproblemResults[i - j]);
            }
            subproblemResults[i + 1] = max;
        }

        return subproblemResults[n];
    }

    private void initialize(int[] subproblems) {
        subproblems[0] = 0;
        for (int i = 1; i < subproblems.length; i++) {
            subproblems[i] = Integer.MIN_VALUE;
        }
    }

    /**
     * Returns list of rod set which yields the maximum revenue
     * @param n
     * @return
     */
    List<Integer> optimalRods(int n){
        int[] subproblemResults = new int[n + 1];//first element is 0 for intialization purpose
        int[] rodLengthResults = new int[n+1];
        initialize(subproblemResults);
        initialize(rodLengthResults);

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                if(max < this.prices[j] + subproblemResults[i - j]){
                    max = this.prices[j] + subproblemResults[i - j];
                    rodLengthResults[i+1] = j+1;
                }
            }
            subproblemResults[i + 1] = max;
        }

        List<Integer> optimamRods = new ArrayList<>();
        while(n > 0 ){
            optimamRods.add(rodLengthResults[n]);
            n = n - rodLengthResults[n];

        }

        return optimamRods;
    }

}
