/**
 * Problem: 73. Set Matrix Zeroes
 * Link: https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Approach:
 * - Use first row and first column as markers.
 * - Traverse the matrix:
 *      - If any cell is 0 → mark its row & column by setting:
 *          matrix[i][0] = 0 and matrix[0][j] = 0
 *      - Also track if first row or first column originally had any 0.
 *
 * - Traverse again (excluding first row & column):
 *      - If corresponding row/column marker is 0 → set cell to 0.
 *
 * - Finally:
 *      - If first row had a 0 → make entire first row 0.
 *      - If first column had a 0 → make entire first column 0.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)  (in-place using matrix itself)
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstrow = false, firstcol = false;

        // Step 1: Mark rows and columns
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) firstrow = true;
                    if(j == 0) firstcol = true;

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Step 2: Update inner matrix
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Step 3: Update first row if needed
        if(firstrow){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        // Step 4: Update first column if needed
        if(firstcol){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
