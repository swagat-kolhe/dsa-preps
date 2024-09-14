package com.leetcode.solutions;

/**
 * https://leetcode.com/discuss/interview-question/1531556/coder-pad-round-goldman-sachs
 * <p>
 * grid = [[0, 0, 0, 0, 5], [0, 0, 0, 0, 5], [2, 0, 0, 0, 0]]
 * print(maxPathSum(grid))
 */
public class MaximumPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}
        };
        MaximumPathSum app = new MaximumPathSum();
        System.out.println(app.maxCollectRocks(grid));
    }

    public int calculate(int[][] grid, int i, int j) {
        if (i < 0 || j == grid[0].length) return Integer.MIN_VALUE;
        if (i == 0 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.max(calculate(grid, i - 1, j), calculate(grid, i, j + 1));
    }

    public int maxCollectRocks(int[][] grid) {
        return calculate(grid, grid.length - 1, 0);
    }
}
