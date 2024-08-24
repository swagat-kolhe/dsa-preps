package com.hackerrank.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingWords {

    public static void main(String[] args) {
        String s = "I am using hackerrank to improve programming";
        String t = "am hackerrank to improve";
        List<String> str = findMissingWords(s, t);
        for (int i = 0; i < str.size(); i++)
            System.out.println(str.get(i));
    }

    public static List<String> findMissingWords(String str, String expectedWords) {
        Set<String> expected = Arrays.stream(expectedWords.split("\\W+")).collect(Collectors.toSet());
        List<String> existed = Arrays.stream(str.split("\\W+")).collect(Collectors.toList());
        existed.removeAll(expected);
        return existed;
    }

}
