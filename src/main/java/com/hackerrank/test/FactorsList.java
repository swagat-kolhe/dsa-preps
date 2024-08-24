package com.hackerrank.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FactorsList {

    public static void main(String[] args) {
        getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        return (int) IntStream.rangeClosed(a.get(a.size() - 1), b.get(0))
                .peek(System.out::println)
                .filter(i -> a.stream().filter(value -> i % value == 0).count() == a.size())
                .peek(System.out::println)
                .filter(i -> b.stream().filter(value -> value % i == 0).count() == b.size())
                .count();
    }

}
