/*
Problem: 48. Rotate Image
Link: https://leetcode.com/problems/rotate-image/

Approach:
- Rotate the matrix by 90 degrees clockwise in-place.
- Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
- Step 2: Reverse each row

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

class Solution {
    public void rotate(int[][] matrix) {

        // Step 1: Transpose
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for(int i = 0; i < matrix.length; i++){
            int left = 0, right = matrix.length - 1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
