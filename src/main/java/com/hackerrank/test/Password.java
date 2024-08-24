package com.hackerrank.test;

public class Password {

    public static void main(String[] args) {
        System.out.println(solution("test 5 a0A pass007 ?xy1"));
    }

    public static int solution(String S) {
        // Implement your solution here
        String[] inputs = S.split("\\s+");
        int max = 0;
        for (String input : inputs) {
            if (input.matches("^^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$")) {
                max = Math.max(max, input.length());
                System.out.println(input);
                System.out.println(input.replaceAll("\\d+", ""));
                System.out.println(input.replaceAll("[^-?0-9]+", ""));
            }
        }
        return max;
    }

}
