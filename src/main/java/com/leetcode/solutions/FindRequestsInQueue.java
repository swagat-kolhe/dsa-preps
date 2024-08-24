package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class FindRequestsInQueue {

    public static void main(String[] args) {
        //int[] wait = new int[] {2, 2, 3, 1};
        int[] wait = new int[] {3,1,2,1};
        for(int i : findRequestsInQueue(wait)){
            System.out.println(i);
        }
    }

    public static int[] findRequestsInQueue(int[] wait) { // O(N)
        int requests = wait.length; // # of pending requests
        Map<Integer, Integer> counts = new HashMap<>();
        for (int time : wait) {
            counts.compute(time, (k, v) -> v == null ? 1 : v + 1);

        }
        //System.out.println(counts);
        int n = wait.length;
        int[] result = new int[n];
        int time = 0; // real / running time
        for (int waitingTime : wait) {
            if (waitingTime > time) {
                result[time++] = requests--;
                counts.compute(waitingTime, (k, v) -> v == 1 ? null : v - 1);
            }
            Integer noOfReqExpired = counts.remove(time);
            if (noOfReqExpired != null) {
                requests -= noOfReqExpired;
            }
        }
        return result;
    }
}
