package com.hackerrank.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CylenderStacksHeight {

    public static void main(String[] args) {

        List<Integer> h1 = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 1, 1, 1}));
        List<Integer> h2 = new LinkedList<>(Arrays.asList(new Integer[]{4, 3, 2}));
        List<Integer> h3 = new LinkedList<>(Arrays.asList(new Integer[]{1, 1, 4, 1}));
        System.out.println(equalStacks(h1, h2, h3));

        List<Integer> h4 = new LinkedList<>(Arrays.asList(new Integer[]{1, 1, 1, 1, 2}));
        List<Integer> h5 = new LinkedList<>(Arrays.asList(new Integer[]{3, 7}));
        List<Integer> h6 = new LinkedList<>(Arrays.asList(new Integer[]{1, 3, 1}));

        System.out.println(equalStacks(h4, h5, h6));

    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        // Write your code here

        int equalHeight = 0;

        if (h1.isEmpty() || h2.isEmpty() || h3.isEmpty()) {
            return equalHeight;
        }

        int height1 = h1.stream().mapToInt(i -> i).sum();
        int height2 = h2.stream().mapToInt(i -> i).sum();
        int height3 = h3.stream().mapToInt(i -> i).sum();

        while (!h1.isEmpty() || !h2.isEmpty() || !h3.isEmpty()) {
            System.out.println(height1 + " , " + height2 + " , " + height3);
            if (height1 == height2 && height1 == height3) {
                equalHeight = height3;
                return height3;
            } else {
                if (height1 >= height2 && height1 >= height3) {
                    height1 = remove(h1, height1);
                } else if (height2 >= height1 && height2 >= height3) {
                    height2 = remove(h2, height2);
                } else if (height3 >= height1 && height3 >= height2) {
                    height3 = remove(h3, height3);
                }
            }
        }

        return equalHeight;
    }

    private static int remove(List<Integer> list, int sum) {
        if (!list.isEmpty()) {
            sum = sum - list.get(0);
            list.remove(0);
        }
        return sum;
    }

}
