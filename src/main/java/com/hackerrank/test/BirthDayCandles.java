package com.hackerrank.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BirthDayCandles {

    public static void main(String[] args) {
        System.out.println(birthdayCakeCandles(Arrays.asList(new Integer[]{3, 2, 1, 3})));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        Map<Integer, Long> map = candles.stream().filter(c -> c <= Math.pow(10, 7)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Math.toIntExact(map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).findAny().get().getValue());
    }

}
