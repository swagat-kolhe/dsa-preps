package com.leetcode.solutions;

/**
 * https://leetcode.com/problems/sudoku-solver/description/
 * <p>
 * https://www.youtube.com/watch?v=H5i2ugoZLbg
 */
public class SudokuSolver {

    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        helper(0, 0);
    }

    private boolean helper(int row, int col) {
        if (col == 9) {
            row += 1;
            col = 0;
        }
        if (row == 9)
            return true;
        if (board[row][col] != '.') {
            return helper(row, col + 1);
        }
        for (char i = '1'; i <= '9'; i++) {
            if (!isValid(row, col, i))
                continue;
            board[row][col] = i;
            if (helper(row, col + 1))
                return true;
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(int row, int col, char cur) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == cur)
                return false;
            if (board[i][col] == cur)
                return false;
        }
        int rowBox = row / 3;
        int colBox = col / 3;
        for (int i = rowBox * 3; i < (rowBox + 1) * 3; i++) {
            for (int j = colBox * 3; j < (colBox + 1) * 3; j++) {
                if (board[i][j] == cur)
                    return false;
            }
        }
        return true;
    }

}
