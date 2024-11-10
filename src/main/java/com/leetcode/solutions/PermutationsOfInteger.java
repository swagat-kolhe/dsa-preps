package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=H232aocj7bQ
 * <p>
 * https://leetcode.com/problems/permutations/description
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class PermutationsOfInteger {

    public static void main(String[] args) {
        int[] nums = new int[] { 1 , 2 , 3};
        PermutationsOfInteger p = new PermutationsOfInteger();
        p.permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int num : nums) {
            if (tempList.contains(num)) continue;
            tempList.add(num);
            backtrack(result, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }


}
