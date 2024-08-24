package com.hackerrank.test;

public class ShiftArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 8, 9, 7, 6};
        revereseArray(nums);
        shiftArray(nums, 3);

    }

    public static int[] shiftArray(int[] nums, int k) {
        // Implement your solution here
        int n = nums.length;
        if (n == 0 || n == k) {
            return nums;
        }
        for (int i = 0; i < k; i++) {
            int lastVal = nums[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = lastVal;
        }
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
        return nums;
    }

    public static int[] revereseArray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int temp;
        while (start <= end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
        return nums;
    }

}
