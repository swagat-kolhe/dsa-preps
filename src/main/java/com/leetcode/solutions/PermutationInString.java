package com.leetcode.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string
 */
public class PermutationInString {

    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        // Initialize frequency arrays for the first window in s2
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, s2Freq)) return true;

        // Slide the window through s2
        for (int i = s1.length(); i < s2.length(); i++) {
            s2Freq[s2.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Freq, s2Freq)) return true;
        }
        return false;
    }
}
