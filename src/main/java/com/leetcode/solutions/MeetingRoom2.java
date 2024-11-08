package com.leetcode.solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/description
 * <p>
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * Example 1:
 * <p>
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRoom2 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {0, 30}, {5, 10}, {15, 20}
        };
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals based on start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Create a priority queue to store end times
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        // Iterate through intervals
        for (int[] interval : intervals) {
            if (!endTimes.isEmpty() && endTimes.peek() <= interval[0]) {
                // If the earliest ending meeting ends before the current meeting starts,
                // we can reuse the room
                endTimes.poll();
            }
            endTimes.add(interval[1]);
        }

        // The size of the priority queue represents the number of rooms needed
        return endTimes.size();
    }

}
