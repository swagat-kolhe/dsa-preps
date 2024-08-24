package com.hackerrank.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChocolateBarSquare {

    public static void main(String[] args) {

        List<Integer> sq = Arrays.asList(1, 2, 1, 3, 2);
        int noSq = 2;
        int bdaySum = 3;

        System.out.println(birthday(sq, bdaySum, noSq));

        Optional<Entry<Integer, Long>> result = sq.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
        if (result != null && result.isPresent()) {


        }

    }

    public static int birthday(List<Integer> sq, int bdaySum, int noOfSq) {
        // Write your code here
        int result = 0;
        for (int i = 0; i < sq.size(); i++) {
            int sum = 0;
            for (int j = i; j < i + noOfSq && j < sq.size(); j++) {
                sum += sq.get(j);
            }
            if (sum == bdaySum) {
                result++;
            }
        }
        return result;
    }

}
