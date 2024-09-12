package com.leetcode.solutions;

/**
 * https://leetcode.com/discuss/interview-question/1218147/goldman-coderpad
 */
public class CycleInArrayCountLengthOfCycle {

    public static void main(String[] args) {
        System.out.println(countLengthOfCycle(new int[]{1, 0}, 1));
        System.out.println(countLengthOfCycle(new int[]{1, 2, 0}, 0));
    }

    private static int countLengthOfCycle(int[] arr, int startIndex) {
        int slow = arr[startIndex];
        int fast = arr[arr[startIndex]];
        int count = 1;
        while (slow != fast) {
            if (fast > arr.length) {
                return -1;
            }
            slow = arr[slow];
            fast = arr[arr[fast]];
            count++;
        }
        return count;
    }
}
