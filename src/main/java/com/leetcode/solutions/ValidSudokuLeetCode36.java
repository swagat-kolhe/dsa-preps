package com.leetcode.solutions;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 * <p>
 * https://www.youtube.com/watch?v=Pl7mMcBm2b8
 */
public class ValidSudokuLeetCode36 {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentValue = board[i][j];
                if (currentValue != '.') {
                    if (!seen.add(currentValue + " found in row " + i) ||
                            !seen.add(currentValue + " found in col " + j) ||
                            !seen.add(currentValue + " found in sub-box " + i / 3 + "-" + j / 3)
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
