package com.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {

    public static void main(String[] args) {
        String myTime = "07:05:45PM";
        SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm:ssaa");
        SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        try {
            date = sdf12.parse(myTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedTime = sdf24.format(date);

        System.out.println(formattedTime);
    }

}
