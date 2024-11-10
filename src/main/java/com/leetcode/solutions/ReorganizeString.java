package com.leetcode.solutions;

import java.util.PriorityQueue;

/**
 *https://leetcode.com/problems/reorganize-string/description
 *
 * https://www.youtube.com/watch?v=wZENBuWh-C0
 *
 */
public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println((char)('a') + 1);
    }

    public static void main1(String[] args) {
        String s = "aab";
        String ans = reorganizeString(s);
        System.out.println(ans);
    }

    public static String reorganizeString(String S) {
        int n = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> count[b - 'a'] - count[a - 'a']);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.add((char) ('a' + i));
            }
        }

        if (count[maxHeap.peek() - 'a'] > (n + 1) / 2) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            sb.append(first);
            sb.append(second);

            if (--count[first - 'a'] > 0) {
                maxHeap.add(first);
            }
            if (--count[second - 'a'] > 0) {
                maxHeap.add(second);
            }
        }

        if (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll());
        }

        return sb.toString();
    }
}
