package com.hackerrank.test;

public class LexicoGetSmallestAndLargest {

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        // Initialize min and max as first substring of size k
        String currStr = s.substring(0, k);
        System.out.println(currStr);
        String lexMin = currStr;
        String lexMax = currStr;

        // Consider all remaining substrings. We consider
        // every substring ending with index i.
        for (int i = k; i < s.length(); i++) {
            currStr = currStr.substring(1, k) + s.charAt(i);
            System.out.println(currStr);
            if (lexMax.compareTo(currStr) < 0)
                lexMax = currStr;
            if (lexMin.compareTo(currStr) > 0)
                lexMin = currStr;
        }

        smallest = lexMin;
        largest = lexMax;

        return smallest + "\n" + largest;
    }

}
