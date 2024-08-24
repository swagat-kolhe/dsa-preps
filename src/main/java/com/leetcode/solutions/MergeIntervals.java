package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	// https://leetcode.com/problems/merge-intervals/description/

	public static void main(String[] args) {

		// intervals = [[1,3],[2,6],[8,10],[15,18]]

		int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		intervals = merge(intervals);
		for (int[] in : intervals) {
			for (int i : in) {
				System.out.print(i);
			}
			System.out.print("--");
		}

	}

	public static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

		List<int[]> result = new ArrayList<>();

		int[] newInterval = intervals[0];
		result.add(newInterval);

		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1])
				// Overlapping intervals,
				// update the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {
				// Disjoint intervals,
				// add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

}
