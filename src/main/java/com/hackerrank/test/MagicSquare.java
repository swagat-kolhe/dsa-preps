package com.hackerrank.test;

public class MagicSquare {

    public static void main(String[] args) {
        formingMagicSquare(null);
    }

    private static int formingMagicSquare(int[][] s) {
        int[][][] possibleMagicSquares = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 5}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        int minCost = Integer.MAX_VALUE;

        for (int[][] magicSquare : possibleMagicSquares) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(s[i][j] - magicSquare[i][j]);
                }
            }
            if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

}
