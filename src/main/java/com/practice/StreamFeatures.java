
package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFeatures {

    public static void main(String[] args) {
        List<Integer> sq = Arrays.asList(1, 2, 1, 3, 2);
        // Group By , Sort by values
        Optional<Entry<Integer, Long>> result = sq.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue());
        result.ifPresent(System.out::println);
        //Map<Integer, Animal> map = list.stream().collect(Collectors.toMap(Animal::getId, Function.identity()));

        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);

        Integer max = listOfIntegers
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        return (int) IntStream.rangeClosed(a.get(a.size() - 1), b.get(0))
                .filter(i -> a.stream().filter(value -> i % value == 0).count() == a.size())
                .filter(i -> b.stream().filter(value -> value % i == 0).count() == b.size())
                .count();
    }

}
