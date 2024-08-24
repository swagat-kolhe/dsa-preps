package com.leetcode.solutions;

public class RandomPickWithWeight {

    // https://leetcode.com/problems/random-pick-with-weight/description/

    public static void main(String[] args) {

    }

}

class Solution {

    int[] prefixSums;
    private final int totalSum;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        int preFixSum = 0;
        for (int i = 0; i < w.length; i++) {
            preFixSum += w[i];
            prefixSums[i] = preFixSum;
        }
        this.totalSum = preFixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i = 0;
        for (; i < prefixSums.length; i++) {
            if (target < prefixSums[i]) {
                return i;
            }
        }
        return i - 1;
    }
}
