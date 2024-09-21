package com.leetcode.solutions;

/**
 * https://www.youtube.com/watch?v=SEn4fyMZ22M
 * <p>
 * https://leetcode.com/problems/first-missing-positive/description
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 * <p>
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 * <p>
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive app = new FirstMissingPositive();
        System.out.println(app.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(app.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(app.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int currentIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[currentIndex]) {
                swap(nums, i, currentIndex);
            } else {
                i++;
            }
        }
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
