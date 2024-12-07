package com.hackerrank.test;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 */
public class CoinChangeNoOfWays {

    static int countRecur(int[] coins, int n, int sum) {

        // If sum is 0 then there is 1 solution
        // (do not include any coin)
        if (sum == 0) return 1;

        // 0 ways in the following two cases
        if (sum < 0 || n == 0) return 0;

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        return countRecur(coins, n, sum - coins[n - 1]) + countRecur(coins, n - 1, sum);
    }

    static int count(int[] coins, int sum) {
        return countRecur(coins, coins.length, sum);
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 3}, 4));
        System.out.println(count(new int[]{2, 5, 3, 6}, 10));
        System.out.println(count(new int[]{10}, 10));
    }
}
