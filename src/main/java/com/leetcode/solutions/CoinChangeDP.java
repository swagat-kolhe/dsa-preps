package com.leetcode.solutions;

/**
 * https://www.youtube.com/watch?v=NNcN5X1wsaw
 * <p>
 * <p>
 * https://leetcode.com/problems/coin-change/description
 */
public class CoinChangeDP {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] minCoinsDP = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minCoinsDP[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE) {
                    minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
                }
            }
        }
        if (minCoinsDP[amount] == Integer.MAX_VALUE) return -1;
        return minCoinsDP[amount];
    }
}
