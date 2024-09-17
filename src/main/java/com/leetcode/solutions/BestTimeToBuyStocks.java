package com.leetcode.solutions;

/**
 * https://www.youtube.com/watch?v=E2-heUEnZKU
 * <p>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions
 */
public class BestTimeToBuyStocks {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int currentProfit;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                currentProfit = prices[i] - buyPrice;
                profit = Math.max(currentProfit, profit);
            }
        }
        return profit;
    }
}
