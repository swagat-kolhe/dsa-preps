package com.leetcode.solutions;

/**
 *
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description
 *
 * https://www.youtube.com/watch?v=IhDGx3U4UGs
 *
 *
 */
public class NumberofStepsReduceNumberBinary {

    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
    }
    public static int numSteps(String s) {
        int count = 0;
        int carry = 0;
        for(int i = s.length() - 1 ; i > 0 ; i--) {
            if(((s.charAt(i) - '0') + carry) % 2 == 1) {
                carry = 1;
                count += 2;
            } else {
                count += 1;
            }
        }
        return count + carry;
    }
}
