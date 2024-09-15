package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description
 * <p>
 * https://www.youtube.com/watch?v=iXLMMbdjeNM
 */
public class FindTargetInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int index = search(nums, target);
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        return search(nums, target, left, right);

    }

    private static int search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] >= nums[left]) {
            // Left half is sorted
            if (nums[left] <= target && target <= nums[mid]) {
                return search(nums, target, left, mid - 1);
            } else {
                return search(nums, target, mid + 1, right);
            }
        } else {
            // Right half is sorted
            if (nums[mid] <= target && target <= nums[right]) {
                return search(nums, target, mid + 1, right);
            } else {
                return search(nums, target, left, mid - 1);
            }
        }
    }


}
