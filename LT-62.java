/**
 * LeetCode 62 - Unique Paths
 * Link: https://leetcode.com/problems/unique-paths/
 *
 * Approach:
 * 1. Use Recursion + Memoization (Top-Down DP).
 * 2. Base Cases:
 *    - If (m == 0 || n == 0) → invalid path → return 0
 *    - If (m == 1 && n == 1) → reached destination → return 1
 * 3. At each cell, we can move:
 *    - Right → (m, n-1)
 *    - Down  → (m-1, n)
 * 4. Store results in dp[][] to avoid recomputation.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n) + recursion stack
 */

class Solution {

    int paths(int m, int n, int dp[][]) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;

        if (dp[m][n] != -1) return dp[m][n];

        int rightWays = paths(m, n - 1, dp);
        int downWays = paths(m - 1, n, dp);

        dp[m][n] = rightWays + downWays;
        return dp[m][n];
    }

    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m + 1][n + 1];

        // initialize with -1
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return paths(m, n, dp);
    }
}
