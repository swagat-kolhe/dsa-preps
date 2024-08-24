package com.leetcode.solutions;

import java.util.Arrays;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[] {1,3};
        int[] num2 = new int[] {2};
        System.out.println(findMedianSortedArrays(num1 , num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] combinedNums = new int[length];
        int i = 0 ;
        for(int num : nums1) {
            combinedNums[i] = num;
            i++;
        }
        for(int num : nums2) {
            combinedNums[i] = num;
            i++;
        }
        double median = 0.0;
        Arrays.sort(combinedNums);
        int mid = length / 2;
        if(length % 2 == 0) {
            median = (combinedNums[mid] + combinedNums[mid - 1]) / 2.0;
        } else {
            median = (combinedNums[mid]);
        }
        return median;
    }
}
