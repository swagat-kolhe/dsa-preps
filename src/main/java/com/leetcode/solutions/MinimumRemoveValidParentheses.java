package com.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveValidParentheses {

    //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/

    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexToRemove = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }

}
