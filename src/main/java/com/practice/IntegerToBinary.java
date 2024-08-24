package com.practice;

public class IntegerToBinary {

    public static void main(String[] args) {
        int num = 1041;
        System.out.println(Integer.toBinaryString(num));

        String binaryString = Integer.toBinaryString(num);
        int maxBinaryGap = 0;
        int max = 0;
        char[] chars = binaryString.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                max++;
            } else {
                maxBinaryGap = Math.max(max, maxBinaryGap);
                max = 0;
            }
        }
        System.out.println(maxBinaryGap);


    }

}
