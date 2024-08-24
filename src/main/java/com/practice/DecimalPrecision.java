package com.practice;

import java.util.Arrays;
import java.util.List;

public class DecimalPrecision {

    public static void main(String[] args) {
        plusMinus(Arrays.asList(new Integer[]{-4, 3, -9, 0, 4, 1}));
    }


    public static void plusMinus(List<Integer> arr) {
        if (arr == null || arr.size() > 100) {
            return;
        }
        float postive = 0;
        float negative = 0;
        float zero = 0;

        for (int i = 0; i < arr.size(); i++) {
            int ele = arr.get(i);
            if (ele == 0) {
                zero++;
            } else if (ele > 0) {
                postive++;
            } else {
                negative++;
            }
        }
        System.out.printf("%.6f\n", (postive / arr.size()));
        System.out.printf("%.6f\n", (negative / arr.size()));
        System.out.printf("%.6f\n", (zero / arr.size()));

    }

}
