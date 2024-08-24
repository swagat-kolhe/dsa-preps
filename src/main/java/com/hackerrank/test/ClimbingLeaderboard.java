package com.hackerrank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbingLeaderboard {

    // https://github.com/Java-aid/Hackerrank-Solutions/blob/master/HackerRankDashboard/CoreCS/Algorithms/src/main/java/com/javaaid/hackerrank/solutions/algorithms/sorting/ClimbingTheLeaderboard.java

    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(100, 90, 90, 80);
        List<Integer> player = Arrays.asList(70, 80, 105);
        System.out.println(climbingLeaderboard(ranked, player));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> scores, List<Integer> alice) {
        // Write your code here

        int n = scores.size();
        int m = alice.size();

        List<Integer> result = new ArrayList<>(m);
        List<Integer> rank = new ArrayList<>(n);
        rank.add(1);

        for (int i = 1; i < n; i++) {
            if (scores.get(i) == scores.get(i - 1)) {
                rank.add(rank.get(i - 1));
            } else {
                rank.add(rank.get(i - 1) + 1);
            }
        }

        System.out.println(rank);

        for (Integer score : alice) {
            if (score > scores.get(0)) {
                result.add(1);
            } else if (score < scores.get(n - 1)) {
                result.add(rank.get(n - 1) + 1);
            } else {
                result.add(rank.get(binarySearch(scores, score)));
            }
        }

        for (int i = 0; i < m; i++) {
            int aliceScore = alice.get(i);
            if (aliceScore > scores.get(0)) {
                result.add(1);
            } else if (aliceScore < scores.get(n - 1)) {
                result.add(rank.get(n - 1) + 1);
            } else {
                int index = binarySearch(scores, aliceScore);
                result.add(rank.get(index));
            }
        }

        return result;
    }

    private static int binarySearch(List<Integer> a, int key) {

        int lo = 0;
        int hi = a.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a.get(mid) == key) {
                return mid;
            } else if (a.get(mid) < key && key < a.get(mid - 1)) {
                return mid;
            } else if (a.get(mid) > key && key >= a.get(mid + 1)) {
                return mid + 1;
            } else if (a.get(mid) < key) {
                hi = mid - 1;
            } else if (a.get(mid) > key) {
                lo = mid + 1;
            }
        }
        return -1;
    }

}
