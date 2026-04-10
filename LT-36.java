/*
    LeetCode 36 - Valid Sudoku
    Link: https://leetcode.com/problems/valid-sudoku/

    Approach:
    - Traverse each cell of the board.
    - If the cell is empty ('.'), skip it.
    - Otherwise:
        1. Store the number.
        2. Temporarily mark the cell as '.' to avoid self-check.
        3. Check if placing the number is valid:
            - Check entire row
            - Check entire column
            - Check 3x3 subgrid
        4. If invalid → return false.
        5. Restore the number back.
    - If all cells are valid → return true.

    Time Complexity: O(9 * 9 * 9) ≈ O(1)
    Space Complexity: O(1)
    */

    class Solution {
    public boolean isValid(char[][] board, int row, int col, char num) {

        // check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }

        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // check 3x3 grid
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;

        for (int i = sRow; i < sRow + 3; i++) {
            for (int j = sCol; j < sCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') continue;

                char num = board[i][j];
                board[i][j] = '.'; // temporarily remove

                if (!isValid(board, i, j, num)) return false;

                board[i][j] = num; // restore
            }
        }

        return true;
    }
}
