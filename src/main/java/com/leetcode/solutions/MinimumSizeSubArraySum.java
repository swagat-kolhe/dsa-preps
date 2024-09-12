package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * https://www.youtube.com/watch?v=_8xZYo4gA68
 */
public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            while (target <= sum) {
                minLength = Math.min(minLength, (right - left) + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
