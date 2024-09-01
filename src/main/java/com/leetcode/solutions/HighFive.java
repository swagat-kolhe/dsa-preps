package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighFive {

	/*
	 * 
	 * 
	 * Example 1:

Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
Example 2:

Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
Output: [[1,100],[7,100]]
	 * 
	 */
	public static void main(String[] args) {
		int[][] result = highFive(new int[][]{
				{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87},
				{1, 100}, {2, 100}, {2, 76}});
		System.out.println(result);

	}

	public static int[][] highFive(int[][] items) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int[] student : items) {
			int studentId = student[0];
			int studentScore = student[1];
			List<Integer> scores = new ArrayList<Integer>();
			if (map.containsKey(studentId)) {
				scores = map.get(studentId);
			} 
			scores.add(studentScore);
			map.put(studentId, scores);
		}
		int[][] result = new int[map.size()][2];
		int i = 0;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int score = (int) entry.getValue()
                    .stream()
                    .sorted(Collections.reverseOrder()) // Sort in descending order
					.limit(5) // Take the top five elements
					.mapToInt(Integer::intValue) // Convert to IntStream
					.average() // Calculate the average
					.orElse(0);
			result[i][0] = entry.getKey();
			result[i][1] = score;
			i++;
		}
		return result;
	}

}
