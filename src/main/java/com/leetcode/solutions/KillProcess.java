package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/kill-process/description
 */
public class KillProcess {

    public static void main(String[] args) {

    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Build the graph representing parent-child relationships
        for (int i = 0; i < ppid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(child);
        }

        // Perform DFS to find all processes to kill
        dfs(graph, kill, result);

        return result;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node, List<Integer> result) {
        result.add(node);
        if (graph.containsKey(node)) {
            for (int child : graph.get(node)) {
                dfs(graph, child, result);
            }
        }
    }
}
