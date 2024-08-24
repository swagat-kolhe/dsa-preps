package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UserWebsiteVisitPattern {

	public static void main(String[] args) {
		String[] username = new String[] { "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary" };
		int[] timestamp = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] website = new String[] { "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career" };
		mostVisitedPattern(username, timestamp, website);

		String[] username1 = new String[] { "C1", "C2", "C1", "C2", "C1", "C2", "C1", "C2", "C1", "C2" };
		int[] timestamp1 = new int[] { 0, 0, 1, 1, 2, 2, 3, 3, 4, 5 };
		String[] website1 = new String[] { "A", "E", "B", "B", "C", "C", "D", "D", "E", "A" };

		mostVisitedPattern(username1, timestamp1, website1);

	}

	private static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		Map<String, TreeMap<Integer, String>> map = new HashMap<>();
		for (int i = 0; i < username.length; i++) {
			map.computeIfAbsent(username[i], o -> new TreeMap<>()).put(timestamp[i], website[i]);
		}

		HashMap<String, Integer> patternCount = new HashMap<String, Integer>();
		String maxPattern = "";
		int maxCount = 0;

		for (Map<Integer, String> m : map.values()) {
			List<String> list = new ArrayList<>(m.values());
			Set<String> uniquePatterns = new HashSet<String>();
			if (list.size() < 3) {
				continue;
			}
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					for (int k = j + 1; k < list.size(); k++) {
						StringBuilder builder = new StringBuilder();
						String pattern = builder.append(list.get(i)).append(".").append(list.get(j)).append(".")
								.append(list.get(k)).toString();
						if (uniquePatterns.add(pattern)) {
							patternCount.merge(pattern, 1, Integer::sum);
						}
						if (patternCount.get(pattern) > maxCount
								|| patternCount.get(pattern) == maxCount && pattern.compareTo(maxPattern) < 0) {
							maxCount = patternCount.get(pattern);
							maxPattern = pattern;
						}
					}
				}
			}
		}
		List<String> result = Arrays.asList(maxPattern.split("\\."));
		for (String string : result) {
			System.out.println(string);
		}
		return result;
	}

}
