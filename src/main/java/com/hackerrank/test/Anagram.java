package com.hackerrank.test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

public class Anagram {

    public static void main(String[] args) {
        String str1 = "TestTest";
        String str2 = "testestt";
        if (isAnagram(str1, str2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
    }

    private static boolean isAnagram(String str1, String str2) {
        boolean result = true;
        Map<Character, Integer> str1CharCounts = getCharCounts(str1.toCharArray());
        Map<Character, Integer> str2CharCounts = getCharCounts(str2.toCharArray());
        System.out.println(str1CharCounts);
        System.out.println(str2CharCounts);
        if (str1CharCounts.size() != str2CharCounts.size()) {
            return false;
        }
        for (Entry<Character, Integer> entry : str1CharCounts.entrySet()) {
            if (!str2CharCounts.containsKey(entry.getKey()) || !Objects.equals(str2CharCounts.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return result;
    }

    private static Map<Character, Integer> getCharCounts(char[] chars) {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        for (char c : chars) {
            if (map.containsKey(Character.toLowerCase(c))) {
                Integer count = map.get(Character.toLowerCase(c));
                count = count + 1;
                map.put(Character.toLowerCase(c), count++);
            } else {
                map.put(Character.toLowerCase(c), 1);
            }
        }
        return map;
    }

}
