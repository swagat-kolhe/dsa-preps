package com.leetcode.solutions;

import java.util.HashMap;

/**
 *
 */
public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        fractionToDecimal(4, 333);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) {
            return result.toString();
        }
        result.append(".");
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        while (!remainderMap.containsKey(remainder)) {
            remainderMap.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int repeatingRemainderIndex = remainderMap.get(remainder);
        result.insert(repeatingRemainderIndex, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }
}
