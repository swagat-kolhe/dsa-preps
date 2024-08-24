package com.leetcode.solutions;

import java.util.Stack;

public class BuildingWithOceanView {

    //https://leetcode.com/problems/buildings-with-an-ocean-view/description/
	/* 
	 * 
	 	Example 1:

		Input: heights = [4,2,3,1]
		Output: [0,2,3]
		Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.
		Example 2:
		
		Input: heights = [4,3,2,1]
		Output: [0,1,2,3]
		Explanation: All the buildings have an ocean view.
		Example 3:
		
		Input: heights = [1,3,2,4]
		Output: [3]
		Explanation: Only building 3 has an ocean view.
	 * 
	 */

    public static void main(String[] args) {
        for (int i : findBuildings(new int[]{4, 2, 3, 1})) {
            System.out.println(i);
        }
    }

    private static int[] findBuildings(int[] heights) {
        Stack<Integer> result = new Stack<>();
        result.add(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i - 1] > heights[i]) {
                result.push(i);
            } else {
                while (!result.isEmpty() && heights[result.peek()] <= heights[i]) {
                    result.pop();
                }
                result.push(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
