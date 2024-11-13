package com.leetcode.solutions;

/**
 * Given two numbers as strings like "283756827652387653"+"7529729872398327" return the sum. So you cannot use the integer or other data types
 */
public class SumOfNumbersAsString {

    public static void main(String[] args) {
        System.out.println(addStrings("283756827652387653", "7529729872398327"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            sum = digit1 + digit2 + carry;
            carry = sum / 10;
            builder.append(sum % 10);
        }
        return builder.reverse().toString();
    }
}
