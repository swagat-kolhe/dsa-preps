package com.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description
 *
 * https://www.youtube.com/watch?v=3IETreEybaA
 */
public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        Set<Character> hashSet = new HashSet<>();
        while (right < s.length()) {
            if(!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                max = Math.max(hashSet.size() , max);
                right++;
            } else {
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }


}
