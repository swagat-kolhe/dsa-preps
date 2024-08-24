package com.hackerrank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SubarrayMaxCount {

    public static void main(String[] args) {
        System.out.println(maximum(Arrays.asList(new Integer[]{-1, 2, -4, 4, -1, 2})));
        System.out.println(maxSubArray(new int[]{-1, 2, -4, 4, -1, 2}));
    }

    private static long maximum(List<Integer> arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = arr.size(); j > 1 && i != j && j - i != 1; j--) {
                //System.out.println(arr.subList(i, j));
                //System.out.println(arr.subList(i, j).stream().collect(Collectors.summingInt(Integer::intValue)));
                list.add(arr.subList(i, j).stream().collect(Collectors.summingInt(Integer::intValue)));
            }
        }
        //System.out.println(list.size());
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0);
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxEnding = 0;
        for (int num : nums) {
            max = Math.max(max, maxEnding += num);
            if (maxEnding < 0) {
                maxEnding = 0;
            }
        }
        return max;
    }

}
