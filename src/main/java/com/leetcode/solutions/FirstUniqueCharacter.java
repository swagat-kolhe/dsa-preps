package com.leetcode.solutions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 2);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                result = i;
                break;
            }
        }
        return result;
    }
}
