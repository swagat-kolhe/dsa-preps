package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/rotate-array/
 */

public class RotateArrayLC189 {

    public static void main(String[] args) {
        RotateArrayLC189 r = new RotateArrayLC189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        r.rotate(nums, k);
        for (int i : nums) {
            System.out.print(i + " , ");
        }
    }

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        reverse(nums, 0, l - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, l - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
