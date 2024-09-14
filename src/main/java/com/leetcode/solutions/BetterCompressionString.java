package com.leetcode.solutions;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/better-compression-of-string
 * <p>
 * Example 1:
 * <p>
 * Input: compressed = "a3c9b2c1"
 * <p>
 * Output: "a3b2c10"
 * <p>
 * Explanation:
 * <p>
 * Characters "a" and "b" appear only once in the input, but "c" appears twice, once with a size of 9 and once with a size of 1.
 * <p>
 * Hence, in the resulting string, it should have a size of 10.
 */
public class BetterCompressionString {

    public static void main(String[] args) {
        System.out.println(betterCompression("a3c9b2c1")); // a3b2c10
    }

    public static String betterCompression(String compressed) {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        Character lastchar = null;
        for (int i = 0; i < compressed.length(); i++) {
            if (Character.isDigit(compressed.charAt(i))) {
                count = 10 * count + (compressed.charAt(i) - '0');
            } else {
                if (lastchar != null) {
                    map.put(lastchar, map.getOrDefault(lastchar, 0) + count);
                }
                lastchar = compressed.charAt(i);
                count = 0;
            }
        }
        map.put(lastchar, map.getOrDefault(lastchar, 0) + count);
        map.forEach((k, v) -> builder.append(k).append(v));
        return builder.toString();
    }
}
