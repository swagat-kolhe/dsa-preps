package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/path-with-maximum-gold
 * <p>
 * https://www.youtube.com/watch?v=qlgeXDM1z7A
 */
public class PathWithMaximumGoldLeetCode1219 {

    int rows, columns;
    int[][] directions = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        int maxGold = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j) {

        if (i >= rows || i < 0 || j >= columns || j < 0 || grid[i][j] == 0) {
            return 0;
        }
        int originalGoldValue = grid[i][j];
        grid[i][j] = 0;
        int maxGold = 0;

//        dfs(grid , i -1 , j); // UP
//        dfs(grid , i + 1 , j); // DOWN
//        dfs(grid , i , j+1); // RIGHT
//        dfs(grid , i , j-1); // LEFT

        for (int[] direction : directions) {
            maxGold = Math.max(maxGold, dfs(grid, (i + direction[0]), (j + direction[1])));
        }

        grid[i][j] = originalGoldValue;
        return originalGoldValue + maxGold;
    }
}
