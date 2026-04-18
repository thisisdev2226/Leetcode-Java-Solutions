/**
 * Problem: Spiral Matrix
 * Link: https://leetcode.com/problems/spiral-matrix/
 *
 * Approach:
 * - Use four pointers:
 *   fr (first row), lr (last row), fc (first column), lc (last column)
 * - Traverse the matrix layer by layer in spiral order:
 *   1. Left → Right (top row)
 *   2. Top → Bottom (right column)
 *   3. Right → Left (bottom row)
 *   4. Bottom → Top (left column)
 * - After each traversal, shrink the boundaries.
 * - Add checks after each step to avoid duplicate traversal.
 *
 * Time Complexity: O(m * n)
 * - Every element is visited exactly once.
 *
 * Space Complexity: O(1) (excluding output list)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = arr.length, n = arr[0].length;

        int fr = 0, fc = 0;
        int lr = m - 1, lc = n - 1;

        while (fr <= lr && fc <= lc) {

            // left → right
            for (int j = fc; j <= lc; j++) {
                ans.add(arr[fr][j]);
            }
            fr++;
            if (fr > lr || fc > lc) break;

            // top → bottom
            for (int i = fr; i <= lr; i++) {
                ans.add(arr[i][lc]);
            }
            lc--;
            if (fr > lr || fc > lc) break;

            // right → left
            for (int j = lc; j >= fc; j--) {
                ans.add(arr[lr][j]);
            }
            lr--;
            if (fr > lr || fc > lc) break;

            // bottom → top
            for (int i = lr; i >= fr; i--) {
                ans.add(arr[i][fc]);
            }
            fc++;
        }
        return ans;
    }
}
