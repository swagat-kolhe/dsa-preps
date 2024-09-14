package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class DivisibleBy60 {

    /**
     * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description
     *
     * @param args
     */
    public static void main(String[] args) {
        numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int rem = time[i] % 60;
            int target = 60 - rem;
            if (map.containsKey(target)) {
                ans += map.get(target);
            }
            if (rem != 0) {
                map.put(rem, map.getOrDefault(rem, 0) + 1);
            } else {
                map.put(60, map.getOrDefault(60, 0) + 1);
            }
        }
        return ans;
    }
}
