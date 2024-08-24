package com.hackerrank.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SprintTraining {

    public static void main(String[] args) {
        int n = 5;
        Integer[] sprints = new Integer[]{2, 4, 1, 3};
        System.out.println(getMostVisitedCounts(n, Arrays.asList(sprints)));
    }

    private static int getMostVisitedCounts(int n, List<Integer> sprints) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < sprints.size() - 1; i++) {
            int start = Math.min(sprints.get(i), sprints.get(i + 1));
            int end = Math.max(sprints.get(i), sprints.get(i + 1));
            for (int j = start; j <= end; j++) {
                if (map.containsKey(j)) {
                    map.put(j, (map.get(j) + 1));
                } else {
                    map.put(j, 1);
                }
            }
        }
        System.out.println(map);
        return 0;
    }

}
