package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array
 * <p>
 * https://www.youtube.com/watch?v=7wT5sFELf7Q
 *
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 */
public class FindShortestSubArrayDegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        int minLength = 0;
        int degree = 0;
        Map<Integer, Integer> numsCount = new HashMap<>();
        Map<Integer, Integer> numsSeenAt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsSeenAt.putIfAbsent(nums[i], i);
            numsCount.put(nums[i], numsCount.getOrDefault(nums[i], 0) + 1);
            if (numsCount.get(nums[i]) > degree) {
                degree = numsCount.get(nums[i]);
                minLength = i - numsSeenAt.get(nums[i]) + 1;
            } else if (numsCount.get(nums[i]) == degree) {
                minLength = Math.min(minLength, i - numsSeenAt.get(nums[i]) + 1);
            }
        }
        return minLength;
    }
}
