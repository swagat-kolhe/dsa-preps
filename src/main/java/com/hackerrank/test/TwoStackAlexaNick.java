package com.hackerrank.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoStackAlexaNick {

    // https://www.hackerrank.com/challenges/game-of-two-stacks/problem
    // https://www.youtube.com/watch?v=WMmST9al0DE


    public static void main(String[] args) {
        List<Integer> h1 = new LinkedList<>(Arrays.asList(new Integer[]{4, 2, 4, 6, 1}));
        List<Integer> h2 = new LinkedList<>(Arrays.asList(new Integer[]{2, 1, 8, 5}));
        System.out.println(twoStacks(10, h1, h2));
    }

    public static int twoStacks(int maxSum, List<Integer> stack1, List<Integer> stack2) {
        int aCount = 0, bCount = 0, result = 0, totalSum = 0;

        for (Integer ele : stack1) {
            if (totalSum + ele > maxSum) {
                break;
            }
            totalSum += ele;
            aCount++;
        }
        result = aCount;

        for (Integer ele : stack2) {
            totalSum += ele;
            bCount++;
            while (totalSum > maxSum && aCount > 0) {
                totalSum -= stack1.get(aCount - 1);
                aCount--;
            }
            result = (totalSum <= maxSum) ? Math.max(aCount + bCount, result) : result;
        }
        return result;
    }

}
