package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {

    // https://leetcode.com/problems/subarray-sum-equals-k/description/
	
	/*
	 * 
	 	Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

		A subarray is a contiguous non-empty sequence of elements within an array.
		
		 
		Example 1:
		
		Input: nums = [1,1,1], k = 2
		Output: 2
		Example 2:
		
		Input: nums = [1,2,3], k = 3
		Output: 2
 
	 */

    public static void main(String[] args) {
        subarraySum(new int[]{1, 1, 1}, 2);
    }

    private static void subarraySum(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        count.put(0, 1);
        int answer = 0;
        int preFixSum = 0;
        for (int num : nums) {
            preFixSum += num;
            answer += count.getOrDefault((preFixSum - k), 0);
            count.put(preFixSum, count.getOrDefault(preFixSum, 0) + 1);
        }
    }

}
