package com.leetcode.solutions;

/**
 * https://www.youtube.com/watch?v=FEkZxCl_-ik
 * <p>
 * https://leetcode.com/problems/decode-ways/description
 */
public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }


}
