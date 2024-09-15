package com.leetcode.solutions;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=V5CyomTb-94
 */
public class CircularGameWinner {

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }

    public static int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() != 1) {
            for (int i = 1; i <= k - 1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
