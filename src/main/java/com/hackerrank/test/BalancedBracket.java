package com.hackerrank.test;

import java.util.Stack;

public class BalancedBracket {

    public static void main(String[] args) {
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
        System.out.println(isBalanced("{(([])[])[]}[]"));

        System.out.println(isValid("()"));

    }

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return "NO";
            }
            char poppedChar = stack.pop();
            switch (c) {
                case '}':
                    if (poppedChar == '[' || poppedChar == '(') {
                        return "NO";
                    }
                    break;
                case ']':
                    if (poppedChar == '{' || poppedChar == '(') {
                        return "NO";
                    }
                    break;
                case ')':
                    if (poppedChar == '[' || poppedChar == '{') {
                        return "NO";
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char poppedChar = stack.pop();
            switch (ch) {
                case '}':
                    if (poppedChar == '[' || poppedChar == '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (poppedChar == '{' || poppedChar == '(') {
                        return false;
                    }
                    break;
                case ')':
                    if (poppedChar == '[' || poppedChar == '{') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

}
