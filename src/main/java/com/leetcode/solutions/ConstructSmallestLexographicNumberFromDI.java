package com.leetcode.solutions;

/*

https://leetcode.com/problems/construct-smallest-number-from-di-string/description

Input: pattern = "IIIDIDDD"
Output: "123549876"

 */
public class ConstructSmallestLexographicNumberFromDI {


    public static void main(String[] args) {
        ConstructSmallestLexographicNumberFromDI app = new ConstructSmallestLexographicNumberFromDI();
        System.out.println(app.smallestNumber("IIIDIDDD")); // 123549876
    }

    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        char ch = '1';
        for (int i = 0; i < pattern.length(); i++) {
            char cur = pattern.charAt(i);
            temp.append(ch++);
            if (cur == 'I') {
                result.append(temp.reverse());
                temp = new StringBuilder();
            }
        }
        temp.append(ch++);
        result.append(temp.reverse());
        return result.toString();
    }
}
