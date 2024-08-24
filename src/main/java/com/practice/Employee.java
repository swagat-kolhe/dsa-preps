package com.practice;

public class Employee {

    private String name;
    private String geneder;
    private int age;
    private double salary;

    public Employee(String name, String geneder, int age, double salary) {
        super();
        this.name = name;
        this.geneder = geneder;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return geneder;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", geneder=" + geneder + ", age=" + age + ", salary=" + salary + "]";
    }


}
