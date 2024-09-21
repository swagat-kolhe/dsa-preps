package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 */
public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int num = 0;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = map.get(Character.toString(s.charAt(i)));
            if (4 * num < ans) {
                ans -= num;
            } else {
                ans += num;
            }
        }
        System.out.println(ans);
    }
}
