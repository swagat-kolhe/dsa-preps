package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/powx-n
 * <p>
 * https://www.youtube.com/watch?v=7wcJXZoGKMI
 */
public class PowerOfXN {

    public static void main(String[] args) {

    }

    private static double myPow(double x, int n) {
        return powOf(x, n);
    }

    private static double powOf(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return powOf(1 / x, -n);
        if (n % 2 == 0)
            return powOf(x * x, n / 2);
        else
            return x * powOf(x * x, n / 2);
    }


}
