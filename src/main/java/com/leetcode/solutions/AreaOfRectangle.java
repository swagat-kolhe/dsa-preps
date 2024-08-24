package com.leetcode.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AreaOfRectangle {

    public static void main(String[] args) {
        int[] sides = new int[]{2, 3, 3, 4, 6, 6, 8, 8};
        getMaxTotalArea(sides);
    }

    private static int getMaxTotalArea(int[] sides) {
        int len = sides.length;
        int area = 0;
        Arrays.sort(sides);
        int k = len - 1;
        for (int i = 0; i < len / 4; i++) {
            int l = Math.min(sides[k], sides[len - 1]);
            int b = Math.min(sides[k - 2], sides[k - 3]);
            area += l * b;
            System.out.println(l);
            System.out.println(b);
            k = k - 4;
        }
        System.out.println(area);
        return area;
    }
}
