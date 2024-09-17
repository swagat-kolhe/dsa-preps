package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/number-of-islands/description
 */
public class NoOfIslands {

    /*
     *
     *
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
     * '0's (water), return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands
     * horizontally or vertically. You may assume all four edges of the grid are all
     * surrounded by water.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"],
     * ["1","1","0","0","0"], ["0","0","0","0","0"] ] Output: 1 Example 2:
     *
     * Input: grid = [ ["1","1","0","0","0"], ["1","1","0","0","0"],
     * ["0","0","1","0","0"], ["0","0","0","1","1"] ] Output: 3
     *
     *
     * Constraints:
     *
     * m == grid.length n == grid[i].length 1 <= m, n <= 300 grid[i][j] is '0' or
     * '1'.
     *
     *
     *
     */

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    isIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void isIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        isIsland(grid, i, j - 1);
        isIsland(grid, i, j + 1);
        isIsland(grid, i - 1, j);
        isIsland(grid, i + 1, j);
    }

}
