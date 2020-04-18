package problemSolving.dynamic_programming;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        //update first column
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }
        //update first row
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i-1];
        }
        if(grid.length == 1) {
            return grid[0][grid[0].length-1];
        }
        if(grid[0].length == 1) {
            return grid[grid.length-1][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = Math.min(grid[i-1][j]+grid[i][j], grid[i][j-1]+grid[i][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    private static int[][] updateBoundaries(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {

        }
        return grid;
    }
}
