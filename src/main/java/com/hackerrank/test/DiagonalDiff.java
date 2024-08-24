package com.hackerrank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DiagonalDiff {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(new Integer[]{11, 2, 4}));
        list.add(Arrays.asList(new Integer[]{4, 5, 6}));
        list.add(Arrays.asList(new Integer[]{10, 8, -12}));
        System.out.println(diagonalDifference(list));

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        List<Integer> leftToRightDiagonal = new ArrayList<>();
        List<Integer> rightToLeftDiagonal = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> row = arr.get(i);
            leftToRightDiagonal.add(row.get(i));// 1,5,9
            int ind = (row.size() - 1) - i;
            rightToLeftDiagonal.add(row.get(ind));// 3,5,9
        }
        System.out.println(leftToRightDiagonal);
        System.out.println(rightToLeftDiagonal);
        return Math.abs(leftToRightDiagonal.stream().flatMapToInt(i -> IntStream.of(i)).sum() - rightToLeftDiagonal.stream().flatMapToInt(i -> IntStream.of(i)).sum());

    }

}
