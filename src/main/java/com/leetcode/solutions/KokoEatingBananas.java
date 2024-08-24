package com.leetcode.solutions;

// https://leetcode.com/problems/koko-eating-bananas/

public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] piles = new int[] { 3, 6, 7, 11 };
		System.out.println(minEatingSpeed(piles, 8));

		int[] piles1 = new int[] { 30, 11, 23, 4, 20 };
		System.out.println(minEatingSpeed(piles1, 5));

		int[] piles2 = new int[] { 30, 11, 23, 4, 20 };
		System.out.println(minEatingSpeed(piles2, 6));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int minSpeed = 1;
		int maxSpeed = 0;
		for (int pile : piles) {
			maxSpeed = Math.max(maxSpeed, pile);
		}
		while (minSpeed < maxSpeed) {
			int mid = minSpeed + (maxSpeed - minSpeed) / 2;
			if (canEatInTime(piles, h, mid)) {
				maxSpeed = mid;
			} else {
				minSpeed = mid + 1;
			}
		}
		return minSpeed;
	}

	private static boolean canEatInTime(int[] piles, int h, int speed) {
		int hours = 0;
		for (int pile : piles) {
			hours += Math.ceil((double) pile / speed);
		}
		return hours <= h;
	}

}
