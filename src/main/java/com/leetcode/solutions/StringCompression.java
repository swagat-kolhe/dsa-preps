package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/string-compression/description
 */
public class StringCompression {

    public static void main(String[] args) {

    }

    public int compress(char[] chars) {
        Map<Character , Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ; i < chars.length ; i++) {
            Character ch = chars[i];
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        StringBuilder builder = new StringBuilder();
        map.forEach((k,v) -> builder.append(k).append(v == 1 ? "" : v));
        return builder.length();
    }
}
