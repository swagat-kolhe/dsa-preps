package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/description
 *
 * https://www.youtube.com/watch?v=LLl9fG1ZvMg
 */
public class ContiguousArrayMaxLength {

    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxLength = 0;
        int count = 0;
        countMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (countMap.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countMap.get(count));
            } else {
                countMap.put(count, i);
            }
        }
        return maxLength;
    }


}
