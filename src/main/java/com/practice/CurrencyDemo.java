package com.practice;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CurrencyDemo {

    public static void main(String[] args) {

        String a = "$28,00.55";
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        double d;
        try {
            d = format.parse(a).doubleValue();
            String st = format.format(d);
            System.out.println(d);
            System.out.println(st);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
