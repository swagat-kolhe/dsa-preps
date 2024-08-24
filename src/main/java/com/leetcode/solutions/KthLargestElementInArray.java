package com.leetcode.solutions;

import java.util.Arrays;
import java.util.Collections;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        int[] arrDesc = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        return arrDesc[k - 1];
    }

}
