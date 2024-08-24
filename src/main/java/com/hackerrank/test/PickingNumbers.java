package com.hackerrank.test;

import java.util.Arrays;
import java.util.List;

public class PickingNumbers {

    // https://www.hackerrank.com/challenges/picking-numbers/problem

    public static void main(String[] args) {
        System.out.println(pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
    }

    public static int pickingNumbers(List<Integer> a) {
        int[] frequency = new int[101];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            frequency[a.get(i)]++;
        }
        for (int i = 1; i < 100; i++) {
            result = Math.max(result, frequency[i] + frequency[i - 1]);
        }
        return result;
    }

}
