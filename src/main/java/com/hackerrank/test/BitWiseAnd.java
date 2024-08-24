package com.hackerrank.test;

public class BitWiseAnd {

    public static void main(String[] args) {
        System.out.println(andProduct(12, 15));
    }

    public static long andProduct(long a, long b) {
        // ShiftCount variables counts till
        // which bit every value will convert to 0
        int shiftcount = 0;

        // Iterate through every bit of a and b
        // simultaneously If a == b then we know that beyond
        // that the and value will remain constant
        while (a != b && a > 0) {
            shiftcount++;
            a = a >> 1;
            b = b >> 1;
        }
        return (long) (a << shiftcount);
    }

}
