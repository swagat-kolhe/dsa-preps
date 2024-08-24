package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        int num[] = new int[] {3,2,4};
        int[] result = twoSum(num , 6);
        for(int r : result) {
            System.out.println(r);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        for(int i = 0 ; i < nums.length ; i++) {
            for(int j = i + 1 ; j < nums.length ; j++) {
                if(nums[i] + nums[j] == target) {
                    result = new int[] {i , j};
                    break;
                }
            }
        }
        return result;
    }
}
