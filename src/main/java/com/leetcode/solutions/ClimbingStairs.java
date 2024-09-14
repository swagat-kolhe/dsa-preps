package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * <p>
 * https://www.youtube.com/watch?v=UUaMrNOvSqg
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(8));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
