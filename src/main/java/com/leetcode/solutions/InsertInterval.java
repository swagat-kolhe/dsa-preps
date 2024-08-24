package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
	// Output: [[1,2],[3,10],[12,16]]

	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = new int[] { 4, 8 };
		insert(intervals, newInterval);
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<int[]>();
		for (int[] interval : intervals) {
			if (interval[1] < newInterval[0]) {
				result.add(interval);
			} else if (newInterval[1] < interval[0]) {
				result.add(newInterval);
				newInterval = interval;
			} else {
				newInterval[0] = Math.min(newInterval[0], interval[0]);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			}
		}
		result.add(newInterval);
		return result.toArray(new int[result.size()][]);
	}

}
