package com.hackerrank.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountPairsDiff {

    public static void main1(String[] args) {
        int n = 4;
        List<Integer> list = Arrays.asList(1, 1, 1, 2);
        int k = 1;
        System.out.println(countPairs(n, list, k));
    }

    public static void main(String[] args) {
        int n = 2;
        List<Integer> list = Arrays.asList(1, 2);
        int k = 0;
        System.out.println(countPairs(n, list, k));
    }

    private static int countPairs(int n, List<Integer> list, int k) {
        int count = 0;
        Set<Integer> unique = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(i) + k == list.get(j) || list.get(j) + k == list.get(i)) {
                    if (!unique.contains(list.get(i) + k)) {
                        unique.add((list.get(i) + k));
                        count++;
                    }
                }
                System.out.println(unique);
            }
        }
        return count;
    }

}
