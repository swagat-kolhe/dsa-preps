package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 * <p>
 * https://www.youtube.com/watch?v=vuXym6JnXyg
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */
public class MinimumPathSumGrid {

    int m, n;
    Integer[][] cache;
    int[][] grid;

    public static void main(String[] args) {
        MinimumPathSumGrid app = new MinimumPathSumGrid();
        int[][] input = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        int result = app.minPathSum(input);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        cache = new Integer[m][n];
        return compute(0, 0);
    }

    private int compute(int row, int col) {
        // base case
        if (row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }
        // Found the bottom right
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
        }
        // Check if we pre-computed
        if (cache[row][col] != null) {
            return cache[row][col];
        }
        // Minimum path sum for right & down
        int right = compute(row, col + 1);
        int down = compute(row + 1, col);
        // Save the computed result;
        cache[row][col] = Math.min(right, down) + grid[row][col];
        return cache[row][col];
    }
}
