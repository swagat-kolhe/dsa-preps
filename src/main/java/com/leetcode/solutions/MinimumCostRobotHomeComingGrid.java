package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/description
 * <p>
 * https://www.youtube.com/watch?v=k_xxtsRC-hk
 */
public class MinimumCostRobotHomeComingGrid {

    public static void main(String[] args) {
        MinimumCostRobotHomeComingGrid app = new MinimumCostRobotHomeComingGrid();
        int[] startPos = new int[]{1, 0};
        int[] homePos = new int[]{2, 3};
        int[] rowCosts = new int[]{5, 4, 3};
        int[] colCosts = new int[]{8, 2, 6, 7};
        int total = app.minCost(startPos, homePos, rowCosts, colCosts);
        System.out.println(total);
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int total = 0;

        int x1 = Math.min(startPos[0], homePos[0]);
        int x2 = Math.max(startPos[0], homePos[0]);

        int y1 = Math.min(startPos[1], homePos[1]);
        int y2 = Math.max(startPos[1], homePos[1]);

        if (x1 == startPos[0]) {
            for (int i = x1 + 1; i <= x2; i++) {
                total += rowCosts[i];
            }
        } else {
            for (int i = x1; i < x2; i++) {
                total += rowCosts[i];
            }
        }

        if (y1 == startPos[1]) {
            for (int i = y1 + 1; i <= y2; i++) {
                total += colCosts[i];
            }
        } else {
            for (int i = y1; i < y2; i++) {
                total += colCosts[i];
            }
        }

        return total;
    }


}
