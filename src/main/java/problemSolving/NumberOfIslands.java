package problemSolving;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {

    /**
     * Time complexity: O(ROWxCOL)
     * Space complexity: worse case O(ROWxCOL) when all are 1s
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                //whenever 1 is found, it will mean that atleast one island exist
                if(grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }

    /**
     * DFS run.
     * Note that this is not graph traversal but grid traversal. DFS algo can be used outside of graph as well.
     * Fundamental is same, implementation is different.
     * @param grid
     * @param row
     * @param col
     */
    private static void dfs(char[][] grid, int row, int col) {
        int rowLength = grid.length; //num of rows
        int colLength = grid[0].length; //num of columns

        //break condition
        if(row < 0 || row >= rowLength || //row bound condition
                col < 0 || col >= colLength || //column bound condition
                grid[row][col] == '0') { //water found
            return;
        }

        /**
         * Now run dfs in all 4 directions
         * Note: If diagonal traversal is allowed then just add two more dfs routes
         */
        grid[row][col] = '0'; //marked visited, means make it water so that it does not get counted as island again
        dfs(grid, row - 1, col); //up vertical
        dfs(grid, row + 1, col); //down vertical
        dfs(grid, row, col - 1); //left
        dfs(grid, row, col + 1); //right

    }
}
