package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-sel
 */
public class CountOfSmallerNumAfterSelf {

    public static void main(String[] args) {

    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int idx = getIndex(sortedList, num);
            result.add(idx);
            sortedList.add(idx, num);
        }
        Collections.reverse(result);  // The result needs to be reversed
        return result;
    }

    private int getIndex(List<Integer> sortedList, int num) {
        int left = 0;
        int right = sortedList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
