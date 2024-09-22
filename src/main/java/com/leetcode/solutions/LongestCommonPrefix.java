package com.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int i = 0;
        while (i < Math.min(start.length(), end.length())) {
            if (start.charAt(i) == end.charAt(i)) {
                result.append(start.charAt(i));
            } else {
                break;
            }
            i++;
        }
        return result.toString();
    }
}
