package com.hackerrank.test;

public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys("DDUUDDUDUUUD"));

    }

    public static int countingValleys(String path) {
        // Write your code here
        int level = 0; // 0 is sea-level
        int valleys = 0;

        for (char c : path.toCharArray()) {
            if (c == 'U') {
                level++;
                if (level == 0) {
                    valleys++;
                }
            } else {
                level--;
            }
        }
        return valleys;
    }

}
