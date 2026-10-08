/*
Problem: 867. Transpose Matrix
Link: https://leetcode.com/problems/transpose-matrix/

Approach:
1. Get the number of rows and columns of the original matrix.
2. Create a new matrix of size col x row because rows and columns are swapped.
3. Traverse the new matrix.
4. For every position [i][j], take the value from original matrix[j][i].
5. Return the new matrix.

Time Complexity: O(row * col)
Space Complexity: O(row * col)
*/

class Solution {
    public int[][] transpose(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] b = new int[col][row];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {

                b[i][j] = matrix[j][i];
            }
        }

        return b;
    }
}
