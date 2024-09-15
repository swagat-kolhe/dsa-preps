package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/count-number-of-teams/description
 * <p>
 * https://www.youtube.com/watch?v=UZupIKXnzq8
 */
public class CountNumberOfTeams {

    public static void main(String[] args) {

    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;
        for (int j = 1; j < n - 1; j++) {
            int countSmallerOnLeft = 0;
            int countSmallerOnRight = 0;
            int countLargerOnLeft = 0;
            int countLargerOnRight = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    countSmallerOnLeft++;
                } else if (rating[i] > rating[j]) {
                    countLargerOnLeft++;
                }
            }
            for (int k = j + 1; k < n; k++) {
                if (rating[j] < rating[k]) {
                    countLargerOnRight++;
                } else if (rating[j] > rating[k]) {
                    countSmallerOnRight++;
                }
            }
            teams += (countLargerOnLeft * countSmallerOnRight) + (countSmallerOnLeft * countLargerOnRight);
        }
        return teams;
    }
}
