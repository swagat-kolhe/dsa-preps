package com.hackerrank.test;

import java.util.Arrays;
import java.util.List;

public class BreakingRecords {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1));
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int minScore = scores.get(0);
        int maxScore = scores.get(0);
        int maxCnt = 0;
        int minCnt = 0;

        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            if (score > maxScore) {
                maxCnt++;
                maxScore = score;
            } else if (score < minScore) {
                minCnt++;
                minScore = score;
            }
        }
        return Arrays.asList(maxCnt, minCnt);
    }

}
