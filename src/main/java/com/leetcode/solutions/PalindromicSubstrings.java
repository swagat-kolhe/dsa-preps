package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/palindromic-substrings/description
 * <p>
 * https://www.youtube.com/watch?v=yWI64YT7zvI
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings app = new PalindromicSubstrings();
        System.out.println(app.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            totalCount += countPalindrome(s, i, i);
            totalCount += countPalindrome(s, i, i + 1);
        }
        return totalCount;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
