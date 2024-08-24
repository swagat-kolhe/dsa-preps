package com.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeMainStreams {

    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "male", 30, 400);
        Employee employee2 = new Employee("John1", "female", 30, 1500);
        Employee employee3 = new Employee("John", "male", 30, 1000);
        Employee employee4 = new Employee("John2", "male", 30, 5000);
        Employee employee5 = new Employee("John", "female", 32, 3000);
        Employee employee6 = new Employee("John3", "male", 30, 1000);

        List<Employee> list = new ArrayList<Employee>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);

        List<Employee> list1 = new ArrayList<Employee>();
        list1.add(employee1);
        list1.add(employee2);
        list1.add(employee3);
        list1.add(employee4);
        list1.add(employee5);
        list1.add(employee6);

        System.out.println(list.stream().map(Employee::getName).collect(Collectors.toList()));
        System.out.println(list.stream().map(Employee::getGender).collect(Collectors.toSet()));
        System.out.println(list.stream().distinct().count());
        System.out.println(list.stream().filter(i -> i.getAge() < 32).count());

        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getGender)).keySet().size());
        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).entrySet().stream().min(Map.Entry.comparingByValue()));
        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting())));
        String listToString = list.stream().map(Employee::getName).collect(Collectors.joining(", ", "[", "]"));
        double averagePrice = list.stream().collect(Collectors.averagingInt(Employee::getAge));
        int summingAge = list.stream().collect(Collectors.summingInt(Employee::getAge));

        // System.out.println(list.stream().collect(Collectors.toMap(Employee::getName,
        // Function.identity())));

        System.out.println(list.stream().max(Comparator.comparing(Employee::getSalary)).get());
        System.out.println(list.stream().min(Comparator.comparing(Employee::getSalary)).get());

        List<List<Employee>> lists = new ArrayList<List<Employee>>();
        lists.add(list);
        lists.add(list1);

        System.out.println(lists.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        int reducedTwoParams = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
        System.out.println(reducedTwoParams);
        Map<Boolean, List<Employee>> mapPartioned = list.stream().collect(Collectors.partitioningBy(element -> element.getAge() > 30));

    }

}
