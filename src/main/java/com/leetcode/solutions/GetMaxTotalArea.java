package com.leetcode.solutions;

import java.util.Comparator;
import java.util.stream.IntStream;

public class GetMaxTotalArea {

	public static void main(String[] args) {
		int[] edges = new int[] { 2, 3, 3, 4, 6, 6, 8, 8 };
		getMaxTotalArea(edges);

		int[] edges1 = new int[] { 2, 6, 6, 2, 3, 5 };
		getMaxTotalArea(edges1);
		
		int[] edges2 = new int[] {2,1,6,5,4,4};
		getMaxTotalArea(edges2);
	}

	private static int getMaxTotalArea(int[] edges) {
		int area = 0;
		if (edges.length < 4) {
			return area;
		}
		edges = IntStream.of(edges).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
		int i = 0;
		int ar = 1;
		int total = 0;
		int pairCount = 0;
		while (i < edges.length) {
			if (edges[i] == edges[i + 1] || ((edges[i] - edges[i + 1]) == 1)) {
				ar *= Math.min(edges[i], edges[i + 1]);
				pairCount++;
			}
			i = i + 2;
			if (pairCount == 2) {
				total += ar;
				ar = 1;
				pairCount = 0;
			}
		}
		System.out.println(total);
		return total;
	}

}
