package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/backspace-string-compare
 */
public class BackSpaceString {

    public static void main(String[] args) {
        BackSpaceString app = new BackSpaceString();
        System.out.println(app.backspaceCompare("ab#c", "ad#c"));
    }

    public boolean backspaceCompare(String s, String t) {
        return compare(s).equals(compare(t));
    }

    private String compare(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (builder.length() != 0 && str.charAt(i) == '#') {
                builder.deleteCharAt(builder.length() - 1);
                continue;
            }
            if (str.charAt(i) != '#') {
                builder.append(str.charAt(i));
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}
