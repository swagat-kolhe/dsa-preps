package com.leetcode.solutions;

public class Search2DMatrixBinarySearch {

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        int target = 13;
        boolean result = searchMatrix(input, target);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = matrix[0].length;
        for (int[] arr : matrix) {
            if (target == arr[l - 1]) {
                return true;
            }
            if (target < arr[l - 1]) {
                return binarySearch(arr, target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return false;
    }

}
