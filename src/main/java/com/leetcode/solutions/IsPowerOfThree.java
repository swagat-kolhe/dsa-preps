package com.leetcode.solutions;

public class IsPowerOfThree {

	public static void main(String[] args) {
		isPowerOfThree(3);

	}

	public static boolean isPowerOfThree(int n) {
		if (n == 1) {
			return true;
		}
		if (n % 3 != 0 || n == 0) {
			return false;
		}
		return isPowerOfThree(n / 3);

	}

}
