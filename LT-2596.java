/*
Problem: 2596. Check Knight Tour Configuration
Link: https://leetcode.com/problems/check-knight-tour-configuration/

Approach:
1. Start from grid[0][0], which must contain 0.
2. From the current cell, check all 8 possible knight moves.
3. Move only to the cell containing the next number (num + 1).
4. If the current cell contains n * n - 1, the tour is complete.
5. If no valid next move exists, return false.

Time Complexity: O(N^2)
Space Complexity: O(N^2) in the worst case due to recursion stack.
*/

class Solution {

    public boolean helper(int[][] grid, int row, int col, int num) {

        int n = grid.length;

        // Base case: reached the last number
        if (grid[row][col] == n * n - 1) {
            return true;
        }

        int i, j;

        // 2 up, 1 right
        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < n && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);

        // 2 up, 1 left
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);

        // 2 down, 1 right
        i = row + 2;
        j = col + 1;
        if (i < n && j < n && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);

        // 2 down, 1 left
        i = row + 2;
        j = col - 1;
        if (i < n && j >= 0 && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);

        // 2 right, 1 up
        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < n && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);

        // 2 right, 1 down
        i = row + 1;
        j = col + 2;
        if (i < n && j < n && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);

        // 2 left, 1 up
        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);

        // 2 left, 1 down
        i = row + 1;
        j = col - 2;
        if (i < n && j >= 0 && grid[i][j] == num + 1)
            return helper(grid, i, j, num + 1);

        return false;
    }

    public boolean checkValidGrid(int[][] grid) {

        // The knight tour must start at 0
        if (grid[0][0] != 0) {
            return false;
        }

        return helper(grid, 0, 0, 0);
    }
}
