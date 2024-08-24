package com.hackerrank.test;

import java.util.Stack;

public class MinimumSwapsBalance {

    public static void main(String[] args) {
        System.out.println(minSwaps("[]"));
        System.out.println(minSwaps("][]["));
        System.out.println(minSwaps("]]][[["));


    }

    public static int minSwaps(String s) {
        Stack<Character> stack = new Stack<Character>();
        int mismatched = 1;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    mismatched++;
                }
            }
        }
        return mismatched / 2;
    }

}
