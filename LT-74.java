/**
 * Problem: 74. Search a 2D Matrix
 * Link: https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Approach:
 * - Treat the 2D matrix as a flattened sorted array.
 * - Apply Binary Search on indices [0 ... m*n - 1].
 * - Convert 1D index → 2D index using:
 *      row = mid / n
 *      col = mid % n
 *
 * - Compare matrix[row][col] with target:
 *      - If equal → return true
 *      - If smaller → search right half
 *      - If greater → search left half
 *
 * Time Complexity: O(log(m * n))
 * Space Complexity: O(1)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}
