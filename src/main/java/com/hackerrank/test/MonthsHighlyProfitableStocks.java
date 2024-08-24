package com.hackerrank.test;

import java.util.Arrays;
import java.util.List;

public class MonthsHighlyProfitableStocks {

    public static void main(String[] args) {
        int batch = 5;

        Integer[] all = new Integer[]{4, 5, 7, 9, 10, 12, 13, 14, 16, 17, 18, 2, 3, 5, 2, 6};
        List<Integer> stockPrice = Arrays.asList(all);

        int j = 0;
        int noOfProfitableMonth = 0;
        System.out.println("-------");
        for (int i = 0; i <= stockPrice.size() - batch; i++) {
            j = batch + i;
            if (!check(stockPrice.subList(i, j))) {
                noOfProfitableMonth++;
                System.out.println(stockPrice.subList(i, j));
            }
        }
        System.out.println("-------");
        System.out.println(noOfProfitableMonth);

    }

    private static boolean check(List<Integer> stockPrice) {
        int privousMonthSale = 0;
        boolean priceDropped = false;
        for (Integer currentMonth : stockPrice) {
            if (privousMonthSale > currentMonth) {
                priceDropped = true;
                break;
            }
            privousMonthSale = currentMonth;
        }
        return priceDropped;
    }

}
