package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/jump-game-ii/description
 */
public class JumpGame2 {

    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int jump = 0, farthest = 0, currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jump++;
                currentEnd = farthest;
            }
        }
        return jump;
    }


}
