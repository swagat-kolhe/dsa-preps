package com.hackerrank.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnagramFunwithAnagrams {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<String>(Arrays.asList("code", "doce", "ecod", "framer", "frame"));
        System.out.println(funWithAnagrams(list));

        List<String> list1 = new CopyOnWriteArrayList<String>(Arrays.asList("code", "aaagmnrs", "anagrams", "doce"));
        System.out.println(funWithAnagrams(list1));
    }

    private static List<String> funWithAnagrams(List<String> list) {
        List<String> result = new CopyOnWriteArrayList<String>(list);
        Map<String, Map<Character, Integer>> charCountMapping = new LinkedHashMap<String, Map<Character, Integer>>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).length() == list.get(j).length()) {
                    Map<Character, Integer> charCountForStringOne = getCharacterCount(charCountMapping, list.get(i));
                    Map<Character, Integer> charCountForStringTwo = getCharacterCount(charCountMapping, list.get(j));
                    if (charCountForStringOne.size() == charCountForStringTwo.size() && isAnagram(charCountForStringOne, charCountForStringTwo)) {
                        result.remove(list.get(j));
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    private static Map<Character, Integer> getCharacterCount(Map<String, Map<Character, Integer>> charCountMapping, String item) {
        if (charCountMapping.containsKey(item)) {
            return charCountMapping.get(item);
        }
        Map<Character, Integer> charCountForString = new HashMap<Character, Integer>();
        for (Character ch : item.toCharArray()) {
            if (charCountForString.containsKey(ch)) {
                charCountForString.put(ch, charCountForString.get(ch) + 1);
            } else {
                charCountForString.put(ch, 1);
            }
        }
        return charCountForString;
    }

    private static boolean isAnagram(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey()) && map2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
