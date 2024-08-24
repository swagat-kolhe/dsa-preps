package com.practice;

public class StringSplit {

    public static void main(String[] args) {
        String str = "He is a very very good boy, isn't he?";
        String[] strings = str.split("['!?,._@\\s]+");
        System.out.println(strings.length);
        for (String str1 : strings)
            System.out.println(str1);
    }

}
