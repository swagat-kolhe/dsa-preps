package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/integer-to-roman/description/
 * 
 * https://www.youtube.com/watch?v=gB8JePMXUS8
 */
public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(3749));
		System.out.println(intToRoman(58));
		System.out.println(intToRoman(1994));
	}

	public static String intToRoman(int num) {
		StringBuilder result = new StringBuilder();
		int[] romanNum = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanValues = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		for (int i = 0; i < romanNum.length; i++) {
			while (num >= romanNum[i]) {
				num = num - romanNum[i];
				result.append(romanValues[i]);
			}
		}
		return result.toString();
	}

}
